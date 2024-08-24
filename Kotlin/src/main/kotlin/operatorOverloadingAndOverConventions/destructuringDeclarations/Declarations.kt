package operatorOverloadingAndOverConventions.destructuringDeclarations

/**
 * Для того чтобы реализовать деструктирующее присваивание нужно
 * реализовать функции операторы componentN(), где N обозначает номер
 * переменной в первичном конструкторе.
 */
private class Point(val x: Int, val y: Int) {

    operator fun component1() = x

    operator fun component2() = y
}

/**
 * По умолчанию дата классы реализовывают операторы для деструктирного присваивания
 */
private data class DataPoint(val x: Int, val y: Int)

/**
 * Деструктирующее присваивание также можно использовать в циклах
 */
private fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

private fun example1() {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}

private fun example2() {
    val (x, y) = Point(1, 3)
    println("X: $x") //X: 1
    println("Y: $y") //Y: 3
}

private fun example3() {
    val (x, y) = DataPoint(1, 3)
    println("X: $x") //X: 1
    println("Y: $y") //Y: 3
}

/**
 * В случае если нам не нужен какой-либо из аргументов мы можем использовать знак "_"
 * или не указывать данную переменную если она идет последняя в конструкторе
 */
private fun example4() {
    val (_, y) = Point(1, 3)
    println("Y: $y") //Y: 3
    val (x) = Point(1, 3)
    println("X: $x") //X: 1
}

fun main() {
    example4()
}