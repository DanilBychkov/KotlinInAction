package flowOperators.buffer

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

private fun getUsers() = flow<Int> {
    repeat(3) {
        delay(200L)
        emit(it)
    }
}

private suspend fun getUserProfile(id: String): String {
    delay(2000L)
    return "Profile $id"
}

fun main() = runBlocking {
    getUsers()
        .buffer(3)
        .map { id -> getUserProfile(id = id.toString()) }
        .collect { value -> println(value) }
}