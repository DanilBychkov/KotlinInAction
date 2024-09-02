package generics.out

/**
 * Пример ковариантности
 */

class Box<out T : Animal>(val animal: T)

open class Animal()
class Cat : Animal()


fun main() {

    val a: Animal = Cat()  //так можно
    val b: Box<Animal> = Box(Cat())  //а вот так не получится, только если добавить [out]
}