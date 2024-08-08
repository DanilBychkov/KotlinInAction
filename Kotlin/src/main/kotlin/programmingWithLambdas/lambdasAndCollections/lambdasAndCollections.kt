package programmingWithLambdas.lambdasAndCollections

private class Person(val name: String, val age: Int)

fun main() {
    val persons = listOf(Person("Danil", 12), Person("Maxim", 56))

    val oldest = persons.maxByOrNull { it.age }
    println(oldest?.age)

    /**
     * Пример поиска используя ссылку на член класса
     */
    val oldest2 = persons.maxByOrNull { it.age }
    println(oldest2?.age)
}