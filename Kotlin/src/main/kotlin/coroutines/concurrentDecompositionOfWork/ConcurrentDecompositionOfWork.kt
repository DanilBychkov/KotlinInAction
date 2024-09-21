package coroutines.concurrentDecompositionOfWork

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

private fun getValue(): Int {
    Thread.sleep(1_000L)
    return 5
}


@OptIn(ExperimentalTime::class)
fun main() = runBlocking {
    val measuredTime = measureTime {
        val sum = coroutineScope {
            val firstValue = async(Dispatchers.IO) { getValue() }
            val secondValue = async(Dispatchers.IO) { getValue() }
            firstValue.await() + secondValue.await()
        }
        println("Sum: $sum")
    }

    println("Итоговое время: $measuredTime")
}