package flowOperators.conflate

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

private fun getTemperature() = flow<Int> {
    while (true) {
        delay(1000L)
        emit(Random.nextInt(1, 30))
    }
}

fun main() = runBlocking {
    getTemperature()
        .onEach { i -> println("Received $i") }
        .conflate()
        .collect { value ->
            delay(2000L)
            println("Printed: $value")
        }
}