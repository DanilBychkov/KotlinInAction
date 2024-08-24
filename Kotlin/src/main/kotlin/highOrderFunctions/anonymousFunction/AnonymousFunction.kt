package highOrderFunctions.anonymousFunction

private data class Person(val name: String)

/**
 * Пример использования анонимных функций
 */
private fun lookForAlice(people: List<Person>) {
    people.forEach(fun(person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}

fun main() {
    val people = listOf(Person("Alice"), Person("Bob"))
    lookForAlice(people)
}