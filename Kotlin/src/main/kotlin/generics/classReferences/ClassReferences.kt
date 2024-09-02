package generics.classReferences

import java.security.Provider.Service
import java.util.*

/**
 * Пример получения ссылки на класс с помощью овеществления
 */
private inline fun <reified T> loadService(): ServiceLoader<T> {
    val jClass = T::class.java
    return ServiceLoader.load(jClass)
}

private fun example1() {
    loadService<Service>()
}

inline val <reified T> T.canonical: String
    get() = T::class.java.canonicalName

private fun example2() {
    println(listOf(1, 2, 3).canonical)
    // java.util.List
    println(1.canonical)
    // java.lang.Integer
}


fun main() {
    example2()
}