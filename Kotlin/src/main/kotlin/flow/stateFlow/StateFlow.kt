package flow.stateFlow

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ViewCounter {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun increment() {
        _counter.update { it + 1 }
    }
}

fun main() = runBlocking {
    val vc = ViewCounter()
    launch {
        vc.counter.collect { value ->
            println("Catched value $value")
            //1
        }
    }
    vc.increment()
    println("Value:  ${vc.counter.value}")
    // 1
}