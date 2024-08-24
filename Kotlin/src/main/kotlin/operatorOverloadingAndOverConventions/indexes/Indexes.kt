package operatorOverloadingAndOverConventions.indexes

/**
 * Операции с применением квадратных скобок транслируются в функции get/set
 */
private class MutablePoint(var x: Int, var y: Int) {

    operator fun get(index: Int): Int {
        return when (index) {
            0 -> x
            1 -> y
            else -> throw IndexOutOfBoundsException()
        }
    }

    operator fun set(index: Int, value: Int) {
        when (index) {
            0 -> x = value
            1 -> y = value
            else -> throw IndexOutOfBoundsException()
        }
    }
}

fun main() {
    val p1 = MutablePoint(1, 3)
    println(p1[0]) //1
    p1[0] = 4
    println(p1[0]) //4
}