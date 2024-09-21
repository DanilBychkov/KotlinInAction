package flowOperators.debounce

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

@OptIn(FlowPreview::class)
fun main() = runBlocking {
    val userQuery = flow<String> {
        emit("K")
        delay(50L)
        emit("Ko")
        delay(100L)
        emit("Kot")
        delay(200L)
        emit("Kotli")
        delay(500L)
        emit("Kotlin")
    }
    userQuery
        .debounce(250L)
        .collect { value ->
            println("Searched $value")
        }
    //Kotli
    //Kotlin
}