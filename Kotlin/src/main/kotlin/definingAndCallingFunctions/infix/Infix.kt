package definingAndCallingFunctions.infix

private infix fun String.plus(second: String): String {
    return this + second
}

/**
 * Пример инфиксной записи
 */
fun main() {
    val first = "First"
    val second = "Second"
    println(first plus second)
}