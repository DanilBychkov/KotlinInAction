package workingWithNullableValues.nullabilityOfType

/**
 * По дефолту тип T является Any?
 */
private fun <T> printHashCode(value: T) {
    println(value?.hashCode())
}

/**
 * Для того чтобы исключить возможность передачи null типа, нужно явно
 * установить тип Any
 */
private fun <T : Any> printNotNullHashCode(value: T) {
    println(value.hashCode())
}

fun main() {
    printHashCode(null)
    //printNotNullHashCode(null) //Не можем передать null
}