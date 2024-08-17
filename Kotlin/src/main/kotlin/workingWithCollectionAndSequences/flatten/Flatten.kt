package workingWithCollectionAndSequences.flatten

data class Book(val title: String, val authors: List<String>)

/**
 * Пример использования функции flatMap
 */
private fun example1() {
    val library = listOf(
        Book("Kotlin in Action", listOf("Isakova", "Elizarov", "Aigner", "Jemerov")),
        Book("Atomic Kotlin", listOf("Eckel", "Isakova")),
        Book("The Three-Body Problem", listOf("Liu"))
    )
    println(library.flatMap { it.authors })
    //[Isakova, Elizarov, Aigner, Jemerov, Eckel, Isakova, Liu]
}

/**
 * Пример использования функции flatten
 */
private fun example2() {
    val listInList = listOf(listOf("Hello"))
    println(listInList.flatten())
    //[Hello]
}

fun main() {
    example2()
}