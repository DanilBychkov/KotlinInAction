package kotlinBasics.whenexpression

private enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    val rgb = (r * 256 + g) * 256 + b
    fun printColor() = println("$this is $rgb")
}

private fun getMnemonic(color: Color) = when (color) {
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.YELLOW -> "York"
    Color.GREEN -> "Gave"
    Color.BLUE -> "Battle"
    Color.INDIGO -> "In"
    Color.VIOLET -> "Vain"
}

private fun measureColor() = Color.ORANGE
// as a stand-in for more complex measurement logic

/**
 * Пример объявления переменной непосредственно в блоке when
 */
private fun getWarmthFromSensor(): String = when (val color = measureColor()) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm (red = ${color.r})"
    Color.GREEN -> "neutral (green = ${color.g})"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (blue = ${color.b})"
}

/**
 * Оператор when позволяет использовать разные типы объектов для сравнения
 * Для того чтобы правильно определить нужную ветвь используется проверка на равенство
 */
private fun mix(firstColor: Color, secondColor: Color): Color = when (setOf(firstColor, secondColor)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    else -> throw Exception("Dirty color")
}

/**
 * В оператор when можно также не передавать аргумент,
 * а использовать условия для перехода в нужную ветвь
 */
private fun mixOptimized(firstColor: Color, secondColor: Color): Color {
    return when {
        (firstColor == Color.RED && secondColor == Color.YELLOW) ||
                (firstColor == Color.YELLOW && secondColor == Color.RED) -> Color.ORANGE

        else -> throw Exception("Dirty color")
    }

}

fun main() {
    mix(Color.YELLOW, Color.RED).printColor()
    //ORANGE is 16753920
    mixOptimized(Color.YELLOW,Color.RED).printColor()
    //ORANGE is 16753920
    println(getWarmthFromSensor())
    //warm (red = 255)
    println(getMnemonic(Color.BLUE))
    // Battle
    println(Color.BLUE.rgb)
    // 255
    Color.GREEN.printColor()
    // GREEN is 65280
}