package classesObjectInterfaces.objectMethods

private class Customer(val name: String, val postalCode: Int) {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Customer) return false

        return other.name == name && other.postalCode == postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 27 + postalCode
}

fun main() {
    val firstCustomer = Customer("Alice", 26431)
    val secondCustomer = Customer("Alice", 26431)

    println(firstCustomer == secondCustomer)
}