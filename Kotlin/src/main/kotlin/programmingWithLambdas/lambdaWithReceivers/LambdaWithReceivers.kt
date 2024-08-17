package programmingWithLambdas.lambdaWithReceivers

/**
 * Пример использования lambda with receivers
 */
private fun customBuildString(actions: StringBuilder.() -> Unit): String {
    val builder = StringBuilder()
    builder.actions()
    return builder.toString()
}

fun main() {
    val str = customBuildString {
        append("Hello")
        append(" ")
        append("world")
    }
    println(str)
}