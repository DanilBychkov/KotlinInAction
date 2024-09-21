package flow.coldFlowToStateFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

private fun getValues() = flow<Int> {
    while (true) {
        delay(1000L)
        emit(Random.nextInt())
    }
}

fun main(): Unit = runBlocking {
    val coldFlow = getValues()
    val stateFlow = coldFlow.stateIn(this)

    stateFlow.collect { value ->
        println(value)
    }
}