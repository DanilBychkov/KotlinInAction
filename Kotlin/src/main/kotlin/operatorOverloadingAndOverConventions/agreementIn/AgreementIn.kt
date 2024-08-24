package operatorOverloadingAndOverConventions.agreementIn

private data class Point(val x: Int)

/**
 * Для того, чтобы реализовать оператор in нужно реализовать метод contains
 */
private data class Line(val leftPoint: Point, val rightPoint: Point) {

    operator fun contains(point: Point): Boolean {
        return point.x in leftPoint.x until rightPoint.x
    }
}

fun main() {
    val p1 = Point(-1)
    val p2 = Point(3)
    val p3 = Point(2)
    val line = Line(p1, p2)
    println(p3 in line)
    //true
}