package basicTypes.primitives

/**
 * Примеры использования Unsigned types
 */
private fun example1() {
    val b: UByte = 255u
    val s: UShort = 1u
    val i: UInt = 1u
    val l: ULong = 1u
}

/**
 * При сравнении переменных equals проверяет также тип,
 * поэтому 1 типа Int будет НЕ равна 1 типа Long.
 */
private fun example2() {
    val a: Int = 1
    println(a.equals(1L))
}

/**
 * В Kotlin при приведении типов нужно явно указывать тип
 * к которому хотим привести
 */
private fun example3() {
    val i = 1
    val l: Long = i.toLong()
}

/**
 * Пример как функция toBoolean() работает со строками
 */
private fun example4() {
    println("trUE".toBoolean())
    // true
    println("7".toBoolean())
    // false
    println(null.toBoolean())
    // false
}

/**
 * Пример как функция toBooleanStrict() работает со строками
 */
private fun example5() {
    println("true".toBooleanStrict())
    // true
    println("false".toBooleanStrict())
    // false
    println("TRue".toBooleanStrict())
    // IllegalArgumentException
}

/**
 * Тип Any является базовым типом
 */
private fun example6() {
    val a: Any = 1
    val r = a as? Int
    println(r)
}

fun main() {
    example6()
}