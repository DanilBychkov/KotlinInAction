package flowErrorHandling.coroutineExceptionHandler

import kotlinx.coroutines.*

/**
 * Промежуточный Exception Handler не перехватывает ошибку
 */
private fun CoroutineScope.example1() {
    val intermediateHandler = CoroutineExceptionHandler { context, throwable -> println(throwable) }
    launch(intermediateHandler) {
        throw RuntimeException("Oh!")
    }
}

/**
 * Exception Handler перехватывает ошибку в случае если это supervisor
 */
private fun CoroutineScope.example2() {
    val intermediateHandler = CoroutineExceptionHandler { context, throwable -> println(throwable) }
    launch(intermediateHandler + SupervisorJob()) {
        throw RuntimeException("Oh!")
    }
}

/**
 * Exception Handler перехватывает ошибку в случае если top level coroutine
 */
private suspend fun example3() {
    val topLevelHandler = CoroutineExceptionHandler { context, throwable -> println(throwable) }
    val job = CoroutineScope(topLevelHandler).launch { throw RuntimeException("Oh!") }

    job.join()
}

fun main() = runBlocking {
    example3()
    println("Program Finished!")
}