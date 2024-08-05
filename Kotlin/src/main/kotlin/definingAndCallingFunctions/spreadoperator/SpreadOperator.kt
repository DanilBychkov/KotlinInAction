package definingAndCallingFunctions.spreadoperator

private fun check(vararg numbers: Int) {
    // do nothing
}

/**
 * Пример использования spread operator и vararg
 */
fun main() {
    val listOfNumbers = intArrayOf(1, 2, 3)
    check(*listOfNumbers)
}