package operatorOverloadingAndOverConventions.arithmeticOperations

data class Point(var x: Int, var y: Int) {

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun times(other: Point): Point {
        return Point(x * other.x, y * other.y)
    }

    /**
     * Для того чтобы определить составной оператор присваивания нужно
     * к названию функции добавить суффикс Assign и установить тип
     * возвращаемого значения Unit
     */
    operator fun minusAssign(other: Point) {
        x -= other.x
        y -= other.y
    }

    /**
     * Теоретически, встретив оператор -=, компилятор может вызвать любую из функций minus и minusAssign,
     * поэтому нужно стараться не добавлять сразу обе функции.
     */
    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }

    /**
     * Пример определение унарного оператора
     */
    operator fun inc(): Point {
        return Point(x + 1, y + 1)
    }

    /**
     * Пример переопределения оператора equals
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true //Оптимизация: проверить - не является ли параметр объектом "this"
        if (other !is Point) return false
        return x == other.x && y == other.y
    }
}

private fun example1() {
    var firstPoint = Point(2, 2)
    println(firstPoint++)
    //Point(x=2, y=2)
    println(++firstPoint)
    //Point(x=4, y=4)
    val secondPoint = Point(3, 3)
    println(firstPoint + secondPoint)
    // Point(x=5, y=5)
    secondPoint -= firstPoint
    println(secondPoint)
    // Point(x=-1, y=-1)
    println(firstPoint * secondPoint)
    // Point(x=2, y=2)
    //println(firstPoint / secondPoint)
    //Unresolved reference. None of the following candidates is applicable because of receiver type mismatch.
    //Так как функция div не была определена

}

/**
 * Для того чтобы использовать функции-операторы у Java классов в Kotlin
 * нужно создать функцию с соответствующим именем в Java классе
 * добавлять ключевое слово operator не нужно.
 */
private fun example2() {
    val firstPointJava = PointJava(2, 3)
    val secondPointJava = PointJava(2, 3)
    println(firstPointJava + secondPointJava)
}

/**
 * Пример выполнения унарных операций над Int
 */
private fun example3() {
    var a = 1
    println(-a)
    //-1
    println(+a)
    //1
    println(a++)
    //1
    println(++a)
    //3
}

fun main() {
    example3()
}