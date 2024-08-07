package classesObjectInterfaces.accessorVisibility

/**
 * Пример изменения видимости свойства set
 * Можно получить доступ внутри класса, но не снаружи
 */
class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
    // 3
}