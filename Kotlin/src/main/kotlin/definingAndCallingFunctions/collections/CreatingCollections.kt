package definingAndCallingFunctions.collections

/**
 * Пример получения соответствующих Kotlin Java классов
 */
private fun example1() {
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    // class java.util.LinkedHashSet

    println(list.javaClass)
    // class java.util.Arrays$ArrayList

    println(map.javaClass)
    // class java.util.LinkedHashMap
}

/**
 * Пример создания своего аналога joinToString
 */
@JvmOverloads
fun <T> Collection<T>.customJoinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    forEachIndexed { index, value ->
        if (index != size - 1) {
            result.append(value, separator)
        } else {
            result.append(value, postfix)
        }
    }
    return result.toString()
}

private fun example2() {
    val list = listOf(1, 2, 3)
    val joinString = list.customJoinToString(prefix = "[ ", postfix = " ]")
    println(joinString)
}

fun main() {
    example2()
}