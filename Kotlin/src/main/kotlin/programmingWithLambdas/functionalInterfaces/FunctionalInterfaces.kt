package programmingWithLambdas.functionalInterfaces

private fun interface IntPredicate {

    fun accept(i: Int): Boolean
}

private fun printWithPredicate(value: Int, predicate: IntPredicate) {
    if (predicate.accept(value)) println(value)
}

fun main() {
    val isEven = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }

    buildList<String> {

    }

    /**
     * Однако используя SAM преобразования можно сократить данный код
     */
    val isEven2 = IntPredicate { it % 2 == 0 }

    /**
     * SAM функции можно передавать как аргументы
     */
    printWithPredicate(2) { it % 2 == 0 }

}