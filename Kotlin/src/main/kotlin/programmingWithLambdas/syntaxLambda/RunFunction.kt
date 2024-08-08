package programmingWithLambdas.syntaxLambda

fun main() {
    val myFavouriteNumber = run {
        println("I'm thinking!")
        println("I'm doing some more work...")
        42
    }
    println(myFavouriteNumber)
}