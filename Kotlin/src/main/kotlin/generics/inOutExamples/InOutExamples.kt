package generics.inOutExamples

/**
 * Пример написания функции с использованием in и out
 */

private fun <T> copyData(
    destination: MutableList<T>,
    source: MutableList<out T>
) {
    for (item in source) {
        destination.add(item)
    }
}

private fun <T> copyData2(
    destination: MutableList<in T>,
    source: MutableList<T>
) {
    for (item in source) {
        destination.add(item)
    }
}

fun main() {
    val source = mutableListOf(1, 2, 3)
    val destination = mutableListOf<Any>()
    copyData(destination, source)
    copyData2(destination, source)
}

