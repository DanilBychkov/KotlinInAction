package highOrderFunctions.inlineFunction

import java.util.concurrent.locks.Lock

private class FooClas(initFunction: () -> Unit)

/**
 * Для того чтобы передать лямбда функцию в класс, функция не должна быть встраиваемой.
 * В данном случае функцию, которая не должна быть встраиваемой можно пометить аннотацией noinline
 */
private inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit): FooClas {
    return FooClas(notInlined)
}

private inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action.invoke()
    } finally {
        lock.unlock()
    }
}

/**
 * Пример использования лямбда выражения
 */
private fun example1(l: Lock) {
    println("Before sync")
    synchronized(l) { println("Action") }
    println("After sync")
}

/**
 * Пример как код из [example1] будет скомпилирован
 */
private fun example2(l: Lock) {
    println("Before sync")
    l.lock()
    try {
        println("Action")
    } finally {
        l.unlock()
    }
    println("After sync")
}