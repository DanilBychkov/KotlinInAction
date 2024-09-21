package flowErrorHandling.flowError

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private class UnhappyFlowException : Exception()

private suspend fun example1() {
    val flowWithException = flow {
        repeat(5) {
            emit(it)
        }
        throw UnhappyFlowException()
    }
    try {
        flowWithException.collect { value ->
            println(value)
        }
    } catch (e: UnhappyFlowException) {
        println("$e was caught")
    }
}

private suspend fun example2() {
    val flowWithException = flow {
        repeat(5) {
            emit(it)
        }
        throw UnhappyFlowException()
    }

    flowWithException
        .catch { cause ->
            println(cause)
            emit(-1)
        }.collect { value ->
            println(value)
        }
}

fun main() = runBlocking {
    example2()
}