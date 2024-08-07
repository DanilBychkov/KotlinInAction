package classesObjectInterfaces.innerclass

private class Outer {

    fun method() {}

    /**
     * По умолчанию во вложенных классах отсутствует ссылка на внешний класс
     */
    class Nested {

        fun test() {
            // this@Outer.method() Exception!
        }
    }

    /**
     * Чтобы появилась ссылка на внешний класс, класс должен быть внутренним с модификатором inner
     */
    inner class Inner {

        fun test() {
            this@Outer.method()
        }
    }
}