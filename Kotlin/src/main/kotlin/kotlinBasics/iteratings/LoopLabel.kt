package kotlinBasics.iteratings

/**
 * Пример использования лейблов
 */
fun main(){
    foo@ for (i in 1..100) {
        for (j in 1..100) {
            println("I: $i; J: $j")
            if (j == 5) break@foo
        }
    }
}