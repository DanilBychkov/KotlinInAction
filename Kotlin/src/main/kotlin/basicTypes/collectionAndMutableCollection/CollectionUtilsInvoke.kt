package basicTypes.collectionAndMutableCollection

private fun printInUppercase(list: List<String>) {
    println(CollectionUtils.uppercaseAll(list))
    println(list.first())
}

/**
 * Несмотря на то что список был неизменяемым, значения были изменены
 * так как класс [CollectionUtils] был написан на Java, а в Java отсутствует
 * различие между изменяемыми и неизменяемыми коллекциями.
 * Все коллекции можно изменить.
 */
fun main() {
    val list = listOf("a", "b", "c")
    printInUppercase(list)
    // [A, B, C]
    // A
}