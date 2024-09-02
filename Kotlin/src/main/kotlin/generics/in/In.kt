package generics.`in`

//Иерархия юзеров
private open class User(var rank: Int) {
    override fun toString(): String {
        return "user.rank=$rank"
    }
}

private open class BackendUser(value: Int) : User(value)
private open class Moderator(value: Int) : User(value)
private open class Admin(value: Int) : Moderator(value)


//компаратор с реализацией
private interface Comparator<T> {
    fun compare(o1: T, o2: T): Boolean
}

private val userComparator = object : Comparator<User> { //Сортировать по Юзеру
    override fun compare(firstUser: User, secondUser: User): Boolean {
        return firstUser.rank > secondUser.rank
    }
}


private val moderatorComparator: Comparator<in Moderator> =
    userComparator //Сортировать только модераторов и их потомков


//пузырьковая сортировка
private fun <T : Any> bubbleSort(values: Array<T>, comp: Comparator<in T>) { //использование In
    for (i in values.size - 1 downTo 0) {
        for (j in 0 until i) {
            if (comp.compare(values[j], values[j + 1])) {
                swap(values, j, j + 1)
            }
        }
    }
}

private fun <T : Any> swap(values: Array<T>, f: Int, s: Int) {
    val buff = values[f]
    values[f] = values[s]
    values[s] = buff
}


fun main() {
    val users = arrayOf(User(12220), User(550), User(120))
    val mederators = arrayOf(Moderator(555), Moderator(52220), Moderator(18888))
    val admin = arrayOf(Admin(212), Admin(689), Admin(15))
    val backendUsers = arrayOf(BackendUser(25), BackendUser(69), BackendUser(145))

    //мы можем сортировать с помощью userComparator все типы юзеров
    bubbleSort(users, userComparator)
    bubbleSort(mederators, userComparator)
    bubbleSort(admin, userComparator)
    bubbleSort(backendUsers, userComparator)

    println(users.joinToString())
    println(mederators.joinToString())
    println(admin.joinToString())
    println(backendUsers.joinToString())

    println()

    //moderatorComparator позволяет ограничить использование сортировки только для модераторов и всех кто "ниже" по наследованию
    bubbleSort(mederators, moderatorComparator)
    bubbleSort(admin, moderatorComparator)
}
