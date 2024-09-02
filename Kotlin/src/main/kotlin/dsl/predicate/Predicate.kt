package dsl.predicate

/**
 * Пример вынесения предиката в отдельный класс
 */

private data class Issue(val id: String)

private class IssuePredicate(val projectId: String) : (Issue) -> Boolean {

    override fun invoke(p1: Issue): Boolean {
        return p1.id == projectId
    }
}

fun main() {
    val list = listOf(Issue("1"), Issue("2"))
    val predicate = IssuePredicate("1")
    println(list.filter(predicate))
}