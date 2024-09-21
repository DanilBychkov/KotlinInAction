package flowOperators.transform

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val names = flowOf("First", "Second", "Third")
    val upperAndLowCaseNames = names.transform { value ->
        emit(value.uppercase())
        emit(value.lowercase())
    }
    upperAndLowCaseNames.collect { value ->
        println(value)
    }
}