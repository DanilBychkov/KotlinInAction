package workingWithCollectionAndSequences.ifEmpty

fun main() {
    val empty = emptyList<String>()
    val full = listOf("apple", "orange", "banana")
    println(empty.ifEmpty { listOf("no", "values", "here") })
    // [no, values, here]
    println(full.ifEmpty { listOf("no", "values", "here") })
    // [apple, orange, banana]
    val blankName = " "
    val name = "J. Doe"
    println(blankName.ifEmpty { "(unnamed)" })
    //
    println(blankName.ifBlank { "(unnamed)" })
    // (unnamed)
    println(name.ifBlank { "(unnamed)" })
    // J. Doe
}