package basicTypes.collectionAndMutableCollection

/**
 * Коллекции в Kotlin наследуются от двух интерфейсов : Collection и Mutable Collection
 */
private fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

private fun example1() {
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(1)
    copyElements(source, target)
    println(target)
}

/**
 * Данный пример показывает что даже если коллекция неизменяемая она может измениться.
 * В случае если два списка(изменяемый и неизменяемый) ссылаются на один объект в памяти.
 */
private fun example2() {
    val firstCollection = mutableListOf(1, 2, 3)
    val secondCollection = firstCollection as List<Int>
    println("Ссылаются ли коллекции на один объект? ${firstCollection === secondCollection}")
    //Ссылаются ли коллекции на один объект true
    firstCollection.add(1)
    println("Первая коллекция $firstCollection")
    //Первая коллекция [1, 2, 3, 1]
    println("Вторая коллекция $secondCollection")
    //Вторая коллекция [1, 2, 3, 1]
}


fun main() {
    example2()
}