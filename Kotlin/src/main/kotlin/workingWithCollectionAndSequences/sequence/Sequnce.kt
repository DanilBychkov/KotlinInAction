package workingWithCollectionAndSequences.sequence

private data class Person(val name: String, val age: Int)

/**
 * При создании цепочек преобразований над списком лучше приводить его к последовательностям
 * т.к иначе при каждом вызове функции map filter создается новый список
 */
fun main() {
    val people = listOf(Person("Danil", 28), Person("Alice", 18))

    println(
        people.map(Person::name).filter { it.startsWith("A") }
    )

    println(
        people
            .asSequence()
            .map(Person::name)
            .filter { it.startsWith("A") }
            .toList()
    )
}