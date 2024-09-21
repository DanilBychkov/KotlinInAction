package coroutines.cancel

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking() {
    val value = async {
        delay(500)
        "Value"
    }
    value.cancel()
    println(value.await())
    // JobCancellationException
}