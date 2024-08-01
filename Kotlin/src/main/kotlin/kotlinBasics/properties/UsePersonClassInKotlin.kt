package kotlinBasics.properties

/**
 * Пример исользования джава класса в котлин коде
 */
fun main() {
    val person = PersonJava("Bob",true)
    person.name
    println(person.name)
    // Bob
    println(person.isStudent)
    // true
    person.isStudent = false // Graduation!
    println(person.isStudent)
    // false
}