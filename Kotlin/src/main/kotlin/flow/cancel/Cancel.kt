package flow.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private val counterFlow = flow<Int> {
    repeat(100) { i ->
        emit(i)
        delay(1000L)
    }
}

fun main() = runBlocking {
    val job = launch {
        counterFlow.collect { value ->
            println(value)
        }
    }
    delay(5000)
    job.cancel()
}