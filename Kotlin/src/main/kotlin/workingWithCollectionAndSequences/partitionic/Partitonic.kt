package workingWithCollectionAndSequences.partitionic

private data class Person(val name: String, val age: Int)

/**
 * Пример использования функции partition
 */
private fun example1() {
    val persons = listOf(Person("Danil", 24), Person("Alice", 18))
    val (comeIn, stayOut) = persons.partition { it.age >= 24 }
    println("ComeIn $comeIn")
    println("StayOut $stayOut")
}

fun main() {
    example1()
}