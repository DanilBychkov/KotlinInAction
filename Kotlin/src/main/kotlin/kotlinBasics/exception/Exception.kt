package kotlinBasics.exception

import java.io.BufferedReader
import java.io.StringReader

/**
 * Пример перехвата ошибки с помощю try catch
 */
private fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
        println("Reader was closed")
    }
}

/**
 * Пример использования try catch как выражения
 */
private fun readBuffer2(reader: BufferedReader) {
    val parsedLine = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return //Завершение программы в случае ошибки
    }
    println(parsedLine)
}

private fun example1() {
    val firstReader = BufferedReader(StringReader("239"))
    println(readNumber(firstReader))
    // Reader was closed
    // 239
    val secondReader = BufferedReader(StringReader("a"))
    println(readNumber(secondReader))
    // Reader was closed
    // null
}

private fun example2() {
    readBuffer2(BufferedReader(StringReader("239")))
}

fun main() {
    example2()
}