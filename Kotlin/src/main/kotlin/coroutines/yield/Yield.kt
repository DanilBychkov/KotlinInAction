package coroutines.yield

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

private suspend fun doCpuHeavyWork(): Int {
    var counter = 0
    val startTime = System.currentTimeMillis()
    yield()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++
    }
    return counter
}

fun main() {
    runBlocking {
        launch {
            repeat(3) {
                println(coroutineContext)
                doCpuHeavyWork()
            }
        }
        launch {
            repeat(3) {
                println(coroutineContext)
                doCpuHeavyWork()
            }
        }
    }
}