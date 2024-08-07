package classesObjectInterfaces.backingFiled

/**
 * Пример использования идентификатора field
 */
var backFiledTest: String = "unspecified"
    set(value) {
        field = value + "test"
    }