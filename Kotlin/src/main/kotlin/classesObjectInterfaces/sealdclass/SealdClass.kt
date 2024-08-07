package classesObjectInterfaces.sealdclass

/**
 * Все прямые подклассы sealed класса должны быть известны во время компиляции и
 * объявлены в том же пакете, что и сам закрытый класс,
 */
sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()