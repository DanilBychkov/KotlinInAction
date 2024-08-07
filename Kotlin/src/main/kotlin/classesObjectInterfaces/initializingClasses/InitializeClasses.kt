package classesObjectInterfaces.initializingClasses

/**
 * Способы инициализации класса
 */

private class FirstInitClassExample private constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

private class SecondInitClassExample(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

private class ThirdInitClassExample(val nickname: String)