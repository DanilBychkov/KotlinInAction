package operatorOverloadingAndOverConventions.lazy

/**
 * Пример использования функции lazy
 */
private class Person(val name: String) {

    val emails by lazy { listOf("Email", "Email2") }
}