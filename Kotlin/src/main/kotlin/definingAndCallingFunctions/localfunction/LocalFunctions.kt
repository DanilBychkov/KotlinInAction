package definingAndCallingFunctions.localfunction

private class User(val id: Int, val name: String, val address: String)

/**
 * Пример использования local functions
 */
private fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) throw IllegalArgumentException("Can't save user $id: empty $fieldName")
    }

    validate(name, "Name")
    validate(address, "Addreess")
}

private fun saveUser(user: User) {
    user.validateBeforeSave()
    println("User ${user.name} saved")
}

fun main() {
    saveUser(User(1, "Danil", "Russia"))
}