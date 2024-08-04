package kotlinBasics.iteratings

private fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

/**
 * Пример создания диапазона значений
 * Стоит учитывать что правое значение также входит в диапазон
 */
private fun example1() {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    // 1 2 Fizz 4 Buzz Fizz 7 ...
}

/**
 * Пример создания диапазона значений БЕЗ включения правого значения
 * с использованием знака "<"
 */
@OptIn(ExperimentalStdlibApi::class)
private fun example2() {
    for (i in 1..<100) {
        print(fizzBuzz(i))
    }
}

/**
 * Пример создания диапазона значений БЕЗ включения правого значения
 * с использованием функции until
 */
private fun example3() {
    for (i in 1 until 100) {
        print(fizzBuzz(i))
    }
}

/**
 * Пример создания диапазона значений из символов
 */
private fun example4() {
    for (char in 'a'..'d') {
        print(char)
    }
}

/**
 * Пример прохождения по значениям в map
 */
private fun example5() {
    val binaryReps = mutableMapOf<Char, String>()
    for (char in 'A'..'F') {
        val binary = char.code.toString(2)
        binaryReps[char] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

/**
 * Пример использования функции .withIndex()
 */
private fun example6() {
    val list = listOf("10", "11", "1001")

    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

/**
 * Пример использования функции in для проверки вхождения значения
 * Стоит обратить внимание, что оператор when позволяет комбинировать несколько диапазонов
 * in 'a'..'z', in 'A'..'Z'
 */
private fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}

private fun example7() {
    println(recognize('8'))
}

fun main() {
    example7()
}