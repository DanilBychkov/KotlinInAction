package workingWithCollectionAndSequences.associate

private data class Person(val name: String, val age: Int)

/**
 * Пример использования функции associate
 */
private fun example1() {
    val persons = listOf(Person("Danil", 28), Person("Alice", 20))
    println(persons.associate { it.name to it.age })
    //{Danil=28, Alice=20}
}

/**
 * Пример использования функции associateWith and associateBy
 */
private fun example2() {
    val persons = listOf(
        Person("Joe", 22),
        Person("Mary", 31),
        Person("Jamie", 22)
    )
    println(persons.associateWith { it.age })
    //{Person(name=Joe, age=22)=22, Person(name=Mary, age=31)=31, Person(name=Jamie, age=22)=22}
    println(persons.associateBy { it.age })
    //{22=Person(name=Jamie, age=22), 31=Person(name=Mary, age=31)}
}

fun main() {
    example2()
}