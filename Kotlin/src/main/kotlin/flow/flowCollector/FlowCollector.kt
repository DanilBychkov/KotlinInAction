package flow.flowCollector

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureNanoTime
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main(): Unit = runBlocking {
    val flow = flow<Int> {
        delay(500)
        emit(1)
        delay(500)
        emit(1)
    }
    val measuredTime = measureNanoTime {
        flow.collect { value ->
            println(value)
            delay(200)
        }
    }
    println("Finished with: $measuredTime")
}