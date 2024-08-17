package workingWithNullableValues.ifChecks

private fun printNotNull(value: String) = println(value)

private fun getString(): String? {
    return null
}

fun main() {
    var value: String? = getString()
    value?.length
    if (value != null) {
        value = null
        //Компилятор понимает что значение снова поменялось
        //printNotNull(value)
        //Required:
        //String
        //Found:
        //Nothing?
    }

}