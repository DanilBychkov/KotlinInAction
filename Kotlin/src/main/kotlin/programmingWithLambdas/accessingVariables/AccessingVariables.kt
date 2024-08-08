package programmingWithLambdas.accessingVariables

private class Ref<T>(var value: T)

private fun example1() {
    val counter = Ref(0)
    val inc = { counter.value++ }
    inc.invoke()
    println(counter.value)
}

private fun example2() {
    var counter = 0
    val inc = { counter++ }
    inc.invoke()
    println(counter)
}

fun main() {
    example1()
}