package definingAndCallingFunctions.extensions

private open class View {
    open fun cliked() = println("View clicked")
}

private class Button : View() {
    override fun cliked() = println("Button clicked!")

}

private fun View.showOff() = println("I'm a view!")
private fun Button.showOff() = println("I'm a button!")

/**
 * На данном примере видно, что функции расширения невозможно переопределить
 */
private fun example1() {
    val view: View = Button()
    view.showOff()
    //I'm a view!
}

/**
 * Пример свойств расширений
 */
val String.lastChar
    get() = this[length - 1]

private fun example2() {
    val charts = "abc"
    println(charts.lastChar)
}


fun main() {
    example2()
}