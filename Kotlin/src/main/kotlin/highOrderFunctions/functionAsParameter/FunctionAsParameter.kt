package highOrderFunctions.functionAsParameter

/**
 * Под капотом типы функций объявляются как обычные интерфейсы
 */
private class Adder() : Function2<Int, Int, Int> {

    override fun invoke(p1: Int, p2: Int): Int {
        return p1 + p2
    }
}

private class Adder2() : (Int, Int) -> Int {

    override fun invoke(p1: Int, p2: Int): Int {
        return p1 + p2
    }
}

private fun println(first: Int, second: Int, invokeAdder: (Int, Int) -> Int) {
    println(invokeAdder.invoke(first, second))
}

private fun println2(first: Int, second: Int, invokeAdder: Function2<Int, Int, Int>) {
    println(invokeAdder.invoke(first, second))
}

private fun example1() {
    val adder = Adder()
    println2(1, 2, adder)
}

private fun example2() {
    val adder = Adder()
    println(2, 3, adder)
}

fun main() {
    example2()
}