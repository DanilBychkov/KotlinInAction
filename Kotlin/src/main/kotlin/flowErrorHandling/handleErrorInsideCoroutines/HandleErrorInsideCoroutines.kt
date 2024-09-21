package flowErrorHandling.handleErrorInsideCoroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun CoroutineScope.launchExample() {
    try {
        launch {
            throw UnsupportedOperationException("Ouch!")
        }

    } catch (e: UnsupportedOperationException) {
        println(e)
    }
}

private suspend fun CoroutineScope.asyncExample() {
    val deferred = async { throw UnsupportedOperationException("Ouch!") }
    try {
        deferred.await()
    } catch (e: UnsupportedOperationException) {
        println(e)
    }
}

fun main() = runBlocking {
    //launchExample()
    asyncExample()
    println("ProgramFinished")
}