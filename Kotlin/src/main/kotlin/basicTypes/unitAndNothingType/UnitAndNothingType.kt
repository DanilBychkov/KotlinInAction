package basicTypes.unitAndNothingType

interface Processor<T> {
    fun process(): T
}

/**
 * Ключевое отличие от типа Void,
 * в том что Unit - это полноценный тип,
 * который также можно использовать в качестве аргумента.
 */
class NoResultProcessor : Processor<Unit> {
    override fun process() {
        // do stuff
    }
}

/**
 * Для того чтобы показать, что функция никогда не завершится
 * или ничего не возвращает(к примеру выкидывает исключение),
 * нужно использовать тип Nothing.
 */
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}
