package programmingWithLambdas.memberReferences

private data class Person(val name: String, val age: Int)

/**
 * Пример использования member references
 */
private fun example1() {
    val persons = listOf(Person("Danil", 21), Person("Alice", 18))
    //Первый вариант
    println(persons.maxByOrNull(Person::age))
    //Второй варинат
    println(persons.maxByOrNull { person -> person.age })
}

private fun salute() = println("Salute!")

/**
 * Пример reference on top level function
 */
private fun example2() {
    //Первый вариант
    run { salute() }
    //Второй варинат
    run(::salute)
}

/**
 * Пример construction references
 */
private fun example3() {
    val createPerson = ::Person
    println(createPerson("Alice", 21))
}

private fun Person.isAdult(): Boolean = age >= 18

/**
 * Пример references на функции расширения
 */
private fun example4() {
    val predicate = Person::isAdult
    println(predicate(Person("Danil", 21)))
}

private fun example5() {
    val seb = Person("Sebastian", 28)
    val getSebAge = seb::age
    println(getSebAge())
}

fun main() {
    example5()
}