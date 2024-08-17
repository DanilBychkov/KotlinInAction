package workingWithCollectionAndSequences.windowedAndChunked

/**
 * Пример использования функции windowed и chunked
 */
fun main() {
    val temperatures = listOf(27.7, 29.8, 22.0, 35.5, 19.1)
    println(temperatures.windowed(3))
    // [[27.7, 29.8, 22.0], [29.8, 22.0, 35.5], [22.0, 35.5, 19.1]]
    println(temperatures.windowed(3) { it.sum() / it.size })
    // [26.5, 29.099999999999998, 25.53333333333333]
    println(temperatures.chunked(2))
    // [[27.7, 29.8], [22.0, 35.5], [19.1]]
    println(temperatures.chunked(2) { it.sum() })
    // [57.5, 57.5, 19.1]
}