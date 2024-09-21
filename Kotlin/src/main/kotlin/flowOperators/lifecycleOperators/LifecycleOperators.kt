package flowOperators.lifecycleOperators

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun Flow<Int>.callFlow() = this
    .onEmpty { emit(0) }
    .onStart { println("Flow Started!") }
    .onEach { i -> println("OnEach $i") }
    .onCompletion { cause -> println("Completed!") }

fun main(): Unit = runBlocking {
    val firstFlow = flowOf(1, 2, 3)
    println("FirstFlow")
    firstFlow.callFlow().collect { value ->
        //do nothing
    }

    println("SecondFlow")
    val secondFlow = emptyFlow<Int>()
    secondFlow.callFlow().collect { value ->
        //do nothing
    }
}