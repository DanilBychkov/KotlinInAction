package workingWithCollectionAndSequences.groupBy

/**
 * Пример использования функции groupBy
 */
fun main() {
    val list = listOf("Apple", "Banana", "Apricot")
    println(list.groupBy(String::first))
    //{A=[Apple, Apricot], B=[Banana]}
}