package workingWithNullableValues.platformType

import java.util.*

private fun yellAt(person: Person) {
    println(person.name.uppercase(Locale.getDefault()))
}

private fun yellAtSafe(person: Person) {
    println(person.name?.uppercase(Locale.getDefault()))
}

fun main() {
    /**
     * По умолчанию все типы, приходящие из Java кода являются платформенными типами,
     * то есть могут быть как null, так и не null. Программист сам должен решать как их обрабатывать.
     */
    println(yellAtSafe(Person(null))) // null
    println(yellAt(Person(null))) //NullPointerException
}