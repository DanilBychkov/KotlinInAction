package flowErrorHandling.jobCancellation

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

fun main(): Unit = runBlocking {
    launch(Dispatchers.IO) {
        try {
            while (isActive) {
                println("Heartbeat!")
                Thread.sleep(500L)
                println(isActive)
            }
        } catch (e: Exception) {
            println("Heartbeat terminated: $e")
            throw e
        }
    }
    launch(Dispatchers.IO) {
        delay(1.seconds)
        println("Throw exception")
        throw UnsupportedOperationException("Ow!")
    }
}