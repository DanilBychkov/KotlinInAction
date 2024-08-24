package highOrderFunctions.lock


import java.util.concurrent.Semaphore
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * Пример использования Mutex
 */

/**
private val mutex = Mutex()

private suspend fun accessSharedResource() {
mutex.lock()
try {
// Access the shared resource safely
} finally {
mutex.unlock()
}
}
 */

/**
 * Пример использования ReentrantReadWriteLock
 */

private val readWriteLock = ReentrantReadWriteLock()

private fun readSharedResource() {
    readWriteLock.readLock().lock()
    try {
        // Read from the shared resource
    } finally {
        readWriteLock.readLock().unlock()
    }
}

private fun writeSharedResource() {
    readWriteLock.writeLock().lock()
    try {
        // Write to the shared resource
    } finally {
        readWriteLock.writeLock().unlock()
    }
}

/**
 * Пример использования Semaphore
 */

private val semaphore = Semaphore(3) // Allowing 3 threads concurrently

private fun accessSharedResource2() {
    semaphore.acquire()
    try {
        // Access the shared resource
    } finally {
        semaphore.release()
    }
}

/**
 * Пример использования ReentrantLock
 */

private val reentrantLock = ReentrantLock()

private fun accessSharedResource3() {
    reentrantLock.lock()
    try {
        // Access the shared resource safely
    } finally {
        reentrantLock.unlock()
    }
}