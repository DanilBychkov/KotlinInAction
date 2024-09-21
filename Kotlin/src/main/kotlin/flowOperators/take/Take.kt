package flowOperators.take

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val values = flowOf(1, 2, 3, 4, 5, 6)
    values
        .take(5)
        .collect { value -> println(value) }
}