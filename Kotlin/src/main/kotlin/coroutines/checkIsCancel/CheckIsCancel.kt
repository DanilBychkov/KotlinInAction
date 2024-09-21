package coroutines.checkIsCancel

import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Для того чтобы определить была ли корутина остановлена можно использовать поле isActive
 * или функцию ensureActive()
 */

fun main() = runBlocking {
    val myJob = launch {
        repeat(5) {
            println("Hello!")
            if (!isActive) return@launch
        }
    }
    myJob.cancel()
    //Hello!

    val myJob2 = launch {
        repeat(5) {
            println("Hello!")
            ensureActive()
        }
    }
    myJob2.cancel()
    //Hello!

}