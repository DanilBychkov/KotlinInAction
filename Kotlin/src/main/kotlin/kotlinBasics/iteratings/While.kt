package kotlinBasics.iteratings

/**
 * Пример использования цикла while
 */
private fun example1() {
    var value = 0
    while (true) {
        value += 1
        if (value == 3) continue
        else if (value == 6) break
        else println(value)
    }
}

/**
 * Пример использования цикла do while
 */
private fun example2() {
    var value = 0
    do {
        value += 1
        if (value == 3) continue
        else if (value == 6) break
        else println(value)
    } while (true)
}

fun main() {
    println("Example1")
    example1()
    println("Example2")
    example2()
}
