package generics.typeAlias

private typealias ValidatedInput = String

private fun save(v: ValidatedInput): Unit = TODO()

fun main() {
    val rawInput = "needs validating!"
    save(rawInput)
}