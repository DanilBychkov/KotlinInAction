package operatorOverloadingAndOverConventions.delegates

/**
 * Пример делегирования свойств словарю
 * Ключом является имя переменной
 */
private class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main() {
    val user = User(
        mapOf("name" to "John Doe", "age" to 25)
    )
    println(user.name)
    //John Doe
    println(user.age)
    //25
}