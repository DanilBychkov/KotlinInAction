package classesObjectInterfaces.inlineClasses

interface PrettyPrintable {

    fun prettyPrint()
}

/**
 * Пример реализации inline класса
 * Используются для обертки, более эффективны чем классы
 */
@JvmInline
value class UsdCent(val amount: Int) : PrettyPrintable {

    val salesTax get() = amount * 0.06
    override fun prettyPrint() = println("$amount¢")
}

fun main() {
    val expense = UsdCent(1_99)
    println(expense.salesTax)
    // 11.94
    expense.prettyPrint()
    // 199¢
}