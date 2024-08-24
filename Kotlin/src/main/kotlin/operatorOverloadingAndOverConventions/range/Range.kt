package operatorOverloadingAndOverConventions.range

private data class Point(val x: Int) : Comparable<Point> {

    override fun compareTo(other: Point): Int {
        return x.compareTo(other.x)
    }
}

private operator fun ClosedRange<Point>.iterator(): Iterator<Point> {
    return object : Iterator<Point> {
        var current = start

        override fun hasNext(): Boolean = current.x <= endInclusive.x + 1

        override fun next(): Point = current.also {
            current = Point(current.x + 1)
        }
    }
}

@OptIn(ExperimentalStdlibApi::class)
private operator fun OpenEndRange<Point>.iterator(): Iterator<Point> {
    return object : Iterator<Point> {
        var current = start

        override fun hasNext(): Boolean = current.x <= endExclusive.x

        override fun next(): Point = current.also {
            current = Point(current.x + 1)
        }
    }
}

/**
 * При реализации интерфейса Comparable, становится возможным использования функции rangeTo
 * Стоит отметить что оператор .. транслируется в вызов функции rangeTo.
 * Благодаря функции rangeTo можно проверять входит ли переменная в диапазон,
 * Однако для того чтобы иметь возможность итерироваться по диапазону,
 * нужно реализовать метод расширения Iterator
 */
private fun example1() {
    val point1 = Point(-3)
    val point2 = Point(5)
    val point3 = Point(3)
    val range = point1..point2
    println(point3 in range)
    //true
}

/**
 * Для того, чтобы иметь возможность проходится по диапазону значений
 * должен быть представлен метод расширения над интерфейсом ClosedRange
 */
private fun example2() {
    val point1 = Point(-3)
    val point2 = Point(5)
    val range = point1..point2
    for (point in range) {
        println(point)
    }
    /**
     * Point(x=-3)
     * Point(x=-2)
     * Point(x=-1)
     * Point(x=0)
     * Point(x=1)
     * Point(x=2)
     * Point(x=3)
     * Point(x=4)
     * Point(x=5)
     * Point(x=6)
     */
}

/**
 * Для того чтобы итерировать по диапазону значений без включения последнего элемента
 * нужно реализовать функцию расширения над OpenEndRange
 */
@OptIn(ExperimentalStdlibApi::class)
private fun example3() {
    val point1 = Point(-3)
    val point2 = Point(5)
    val range = point1..<point2
    for (point in range) {
        println(point)
    }
    /**
     * Point(x=-3)
     * Point(x=-2)
     * Point(x=-1)
     * Point(x=0)
     * Point(x=1)
     * Point(x=2)
     * Point(x=3)
     * Point(x=4)
     * Point(x=5)
     * Point(x=5)
     */
}

fun main() {
    example3()
}