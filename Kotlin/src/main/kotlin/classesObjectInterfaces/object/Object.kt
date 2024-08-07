package classesObjectInterfaces.`object`

/**
 * Пример создания объекта
 */
private object Test {

}

/**
 * Пример создания object внутри класса
 */
private data class Person(val name: String) {
    object Compare
}

fun main() {

    val first = Test
    val second = Test

    println(first === second) //True

    val firstPerson = Person("Danil")
    val secondPerson = Person("Alice")

    println(firstPerson === secondPerson)
    println(Person.Compare)
}