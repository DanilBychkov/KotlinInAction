package highOrderFunctions.returnExample

private data class Person(val name: String)

private inline fun iterateUntilFind(people: List<Person>, iterateFunction: (person: Person) -> Unit) {
    people.forEach { person ->
        iterateFunction.invoke(person)
    }
}

/**
 * Пример использования return с лямбда выражением
 */
fun main() {
    val people = listOf(Person("Alice"), Person("Bob"), Person("David"))
    iterateUntilFind(people) { person ->
        if (person.name == "Alice") {
            println("Alice was found")
            return
        }
    }
}

