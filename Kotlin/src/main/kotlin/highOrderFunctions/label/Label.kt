package highOrderFunctions.label

private data class Person(val name: String)

/**
 * Пример использования label с лямбда выражениями
 */
private fun lookForAlice(people: List<Person>) {
    people.forEach label@{
        if (it.name != "Alice") return@label
        print("Found Alice!")
    }
}

private fun example() {
    println(StringBuilder().apply sb@{ listOf(1, 2, 3).apply { this@sb.append(this.toString()) } })
}

fun main() {
    val people = listOf(Person("Danil"), Person("Alice"), Person("Bob"))
    lookForAlice(people)
}