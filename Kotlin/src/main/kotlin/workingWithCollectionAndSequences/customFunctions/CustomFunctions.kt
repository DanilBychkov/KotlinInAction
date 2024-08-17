package workingWithCollectionAndSequences.customFunctions

/**
 * Пример написание аналога filter
 */
private inline fun <T> List<T>.customFilter(prediction: (T) -> Boolean): List<T> = buildList {
    this@customFilter.forEach { element -> if (prediction(element)) add(element) }
}


fun main() {
    val numbers = listOf(1, 2, 3, 4)

    println(numbers.customFilter { it % 2 == 0 })
}