package flow.channelFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * Благодаря использованию channelFlow вместо flow можно расспаралелить работу внутри Flow
 */

suspend fun getNumber(): Int {
    delay(1000L)
    return 1
}

@OptIn(ExperimentalTime::class)
fun main() = runBlocking {
    val time = measureTime {
        val numbers = channelFlow {
            repeat(10) {
                launch { send(getNumber()) }
            }
        }

        numbers.collect { value ->
            println(value)
        }
    }
    println("Measured time: $time")
}