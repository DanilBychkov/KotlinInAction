package workingWithCollectionAndSequences.reduceAndFold

/**
 * Пример использования функции reduce
 */
private fun example1() {
    val numbers = listOf(1, 2, 3, 4)
    val sum = numbers.reduce { acc, i -> acc + i }
    println(sum)
    //10
}

/**
 * Пример использования функции runningReduce
 */
private fun example2() {
    val numbers = listOf(1, 2, 3, 4)
    val sum = numbers.runningReduce { acc, i -> acc + i }
    println(sum)
}


/**
 * Пример использования функции fold
 */
private fun example3() {
    val words = listOf("Bye ", "Danil")
    val word = words.fold("Bye ") { acc, s -> acc + s }
    println(word)
    //Bye Bye Danil
}

/**
 * Пример использования функции runningFold
 */
private fun example4() {
    val words = listOf("Bye ", "Danil")
    val word = words.runningFold("Bye ") { acc, s -> acc + s }
    println(word)
}

fun main() {
    example2()
}