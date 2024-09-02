package generics.where

/**
 * Для того чтобы указать несколько ограничений на параметр T
 * нужно использовать ключевое слово where
 */
private fun <T> print(p: T) where T : Iterator<T>, T : Comparable<T> {
    println(p)
}