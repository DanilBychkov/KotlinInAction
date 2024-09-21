package dsl.matcher

import kotlinx.coroutines.runBlocking

private object start

private class StartWrapper(val value: String) {

    infix fun with(prefix: String) {
        if (!value.startsWith(prefix))
            throw AssertionError()
    }
}

private infix fun String.should(x: start): StartWrapper = StartWrapper(this)

fun main(): Unit = runBlocking {
    "kotlin" should start with "kot"
}