package kotlinBasics.smartcast

private interface Expr
private class Num(val value: Int) : Expr
private class Sum(val left: Expr, val right: Expr) : Expr

/**
 * Пример Smart Cast
 */
private fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
    else -> throw IllegalArgumentException("Unknown expression")
}

/**
 * Пример сложных условий в ветвях when
 */
private fun evalWithLogging(e: Expr): Int = when (e) {
    is Num -> {
        println("Num is ${e.value}")
        e.value
    }

    is Sum -> {
        val resultSum = evalWithLogging(e.left) + evalWithLogging(e.right)
        println("Sum is $resultSum")
        resultSum
    }
    else -> throw IllegalArgumentException("Unknown expression")
}

fun main() {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    // 7
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}
