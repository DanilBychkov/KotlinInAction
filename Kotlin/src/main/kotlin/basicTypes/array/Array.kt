package basicTypes.array

/**
 * Примеры инициализации массива
 */
private fun example1() {
    val firstArray = Array(26) { i -> 'a' + i }
    println(firstArray.joinToString(""))
    // abcdefghijklmnopqrstuvwxyz
    val secondArray = arrayOf(1, 2, 3)
    println(secondArray.joinToString(""))
    // 123
    val thirdArray = arrayOfNulls<Int>(4)
    println(thirdArray.joinToString(""))
    // nullnullnullnull
}

/**
 * Пример использования функции toTypedArray
 */
private fun example2() {
    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))
    // a/b/c
}

/**
 * Пример инициализации массива, состоящего из примитивных типов
 */
private fun example3() {
    val fiveZeros = IntArray(5)
    println(fiveZeros.joinToString())
    val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)
    println(fiveZerosToo.joinToString())
    val squares = IntArray(5) { i -> (i + 1) * (i + 1) }
    println(squares.joinToString())
}

fun main() {
    example3()
}