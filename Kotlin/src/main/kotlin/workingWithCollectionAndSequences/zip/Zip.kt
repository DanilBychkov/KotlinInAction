package workingWithCollectionAndSequences.zip

private data class Person(val name: String, val age: Int)

/**
 * Пример использования функции zip
 * Также функция zip имеет инфиксную запись
 */
fun main() {
    val names = listOf("Joe", "Mary", "Jamie")
    val ages = listOf(22, 31, 31, 44, 0)
    println(names.zip(ages))
    // [(Joe, 22), (Mary, 31), (Jamie, 31)]
    println(names.zip(ages) { name, age -> Person(name, age) })
    // [Person(name=Joe, age=22), Person(name=Mary, age=31),
    // Person(name=Jamie, age=31)]
    println(names zip ages)
    // [(Joe, 22), (Mary, 31), (Jamie, 31)]
}