package workingWithCollectionAndSequences.replace

/**
 * Пример использования функции replaceAll и fill
 */
fun main() {
    val list = mutableListOf("banana", "apple")
    list.replaceAll { it.uppercase() }
    println(list)
    // [BANANA, APPLE]
    list.fill("deleted")
    println(list)
    // [deleted, deleted]
}