package dsl.htmlExample

private open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()

    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    override fun toString(): String =
        "<$name>${children.joinToString("")}</$name>"
}

private fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

private class TABLE : Tag("table") {

    fun tr(init: TR.() -> Unit) = doInit(TR(), init)

}

private class TR : Tag("tr") {

    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

private class TD : Tag("td")

fun main() {
    val function = table {
        tr {
            td {

            }
        }
    }
    println(function)
}