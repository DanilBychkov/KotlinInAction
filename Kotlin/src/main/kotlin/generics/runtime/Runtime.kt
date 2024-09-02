package generics.runtime

/**
 * Для проверки, что данный тип является списком, можно использовать синтаксис проекций
 */
private fun printSum(c: Collection<*>) {
    if (c is List<*>) {
        //do nothing
    }
}

/**
 * Использование приведение типов для опеределения типа списка в RunTime
 */
private fun printSumAndCheck(c: Collection<*>) {
    val intList = c as? List<Int> ?: throw IllegalArgumentException()
    println(intList.sum())
}

/**
 * Пример овеществления типового параметра у функции
 */
private inline fun <reified T> isA(value: Any) = value is T

private fun example1() {
    val intList = listOf(1, 2, 3)
    printSumAndCheck(intList) //6
    //val stringList = listOf("a") //Class cast Exception
    //printSumAndCheck(stringList)
    val setList = setOf("a") //IllegalArgumentException
    printSumAndCheck(setList)
}

private fun example2() {
    println(isA<String>("Hello"))
    //true
    println(isA<String>(2))
    //false
}

fun main() {
    example2()
}