package annotations.reflection

import kotlin.reflect.KFunction1
import kotlin.reflect.full.memberProperties

private class Person(val name: String, val age: Int)

private fun example1() {
    val person = Person("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    //Person
    kClass.memberProperties.forEach { println(it.name) }
    //age
    //name
}

fun fooReflection(x: Int) = println(x)

fun example2Reflection() {
    val kFunction: KFunction1<Int, Unit> = ::fooReflection
    kFunction.call(42)
    //42
    kFunction.invoke(42)
    //42
}

var counterReflection = 0

private fun example3() {
    val kProperty = ::counterReflection
    kProperty.setter.call(42)
    println(kProperty.get())
}

private fun example4() {
    val person = Person("Alice", 29)
    val memberProperty = Person::age
    println(memberProperty.get(person))
}

fun main() {
    example4()
}