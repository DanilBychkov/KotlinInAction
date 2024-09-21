package flowOperators.customFlowOperator

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

private fun Flow<String>.toUpperCase(): Flow<String> = flow {
    collect { value ->
        emit(value.uppercase())
    }
}

fun main() = runBlocking {
    val stings = flowOf("a", "ab", "abc")
    stings
        .toUpperCase()
        .collect { value ->
            println(value)
        }
}