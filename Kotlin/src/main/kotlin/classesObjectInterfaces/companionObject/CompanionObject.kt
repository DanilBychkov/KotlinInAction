package classesObjectInterfaces.companionObject

private interface JsonFactory<T> {
    fun fromJson(jsonText: String): T
}

private class Person(val name: String) {

    /**
     * Объекты компаньоны могут реализовывать интерфейс
     */
    companion object : JsonFactory<Person> {
        override fun fromJson(jsonText: String): Person {
            return Person(jsonText)
        }
    }
}

private fun <T> loadFromJSON(factory: JsonFactory<T>): T {
    TODO()
}

private class User {

    object Helper {
        fun createUser() = User()
    }
}

/**
 * Пример использования companion object с приватным конструктором
 */
private class Employee private constructor(name: String) {

    /**
     * У объектов компаньонов можно установить имя
     * По умолчанию Companion
     */
    companion object Helper {
        fun createUser(name: String) = Employee(name)
    }
}


fun main() {
    val user = User.Helper.createUser()
    val employee = Employee.createUser("Danil")
    val employee2 = Employee.Helper.createUser("Danil")

    /**
     * Объекты компаньоны можно передавать в функцию
     */
    loadFromJSON(Person)
}