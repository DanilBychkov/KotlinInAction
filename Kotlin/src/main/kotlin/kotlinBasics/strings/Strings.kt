package kotlinBasics.strings

fun main() {
    example2()
}

/**
 * Благодаря символу $ можно вставлять переменные в строки
 */
private fun example1() {
    val input = readln()
    val name = input.ifBlank { "Kotlin" }
    println("Hello, $name!")
}

/**
 * Если вам нужно включить символ $ в строку, вы экранируете его обратной косой чертой
 */
private fun example2() {
    println("\$x")
}