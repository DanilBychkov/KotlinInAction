package flow.createFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private fun createValues(): Flow<Int> = flow<Int> {
    emit(1)
    delay(1000)
    emit(2)
    delay(1000)
    emit(3)
    delay(1000)
}

fun main() = runBlocking {
    val flowOfValues = createValues()
    flowOfValues.collect { value ->
        println("Received value: $value")
    }
}