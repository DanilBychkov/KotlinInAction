package highOrderFunctions.use

import java.io.BufferedReader
import java.io.FileReader
import kotlin.io.path.Path
import kotlin.io.path.useLines

/**
 * Пример использования функции [use]
 */
fun readFirstLineFromFile(fileName: String): String {
    BufferedReader(FileReader(fileName)).use { br ->
        return br.readLine()
    }
}

/**
 * Пример использования функции [useLines]
 */
fun readFirstLineFromFile2(fileName: String): String {
    Path(fileName).useLines {
        return it.first()
    }
}