package operatorOverloadingAndOverConventions.comparabable

private class Person(
    val firstName: String, val secondName: String
) : Comparable<Person> {

    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::secondName, Person::firstName)
    }
}

/**
 * Пример реализации методов сравнения для класса
 */
private fun example1() {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")

    println(p1 < p2)
}

fun main() {
    example1()
}