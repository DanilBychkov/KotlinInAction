package kotlinBasics.variables

private fun canPerformOperation(): Boolean {
    return true
}

/**
 * В данном случае компилятор может понять,
 * что значение для переменной result может присвоиться только в двух случаях
 */
private fun example1() {
    val result: String
    if (canPerformOperation()) {
        result = "Success"
    } else {
        result = "Can't perform operation"
    }
    println(result)
}

/**
 * Несмотря на то, что ключевое слово var позволяет переменной изменять свое значение,
 * ее тип является фиксированным.
 */
private fun example2(){
    var answer = 42
    // answer = "no answer" Type mismatch.
}


