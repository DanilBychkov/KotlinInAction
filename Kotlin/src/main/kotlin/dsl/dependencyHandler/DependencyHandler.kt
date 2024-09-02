package dsl.dependencyHandler

private class DependencyHandler {

    fun compile(coordinate: String) {
        println("Added dependency on $coordinate")
    }

    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body() // this.body()
    }
}

fun main() {
    val dependencies = DependencyHandler()
    dependencies {
        compile("First")
    }
    dependencies.compile("Second")
}