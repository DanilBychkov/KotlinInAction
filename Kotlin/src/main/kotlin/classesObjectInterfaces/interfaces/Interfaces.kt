package classesObjectInterfaces.interfaces

private interface Clickable {

    fun onClick()

    fun showOff() = println("I'm clickable!")
}

private interface Focusable {

    fun showOff() = println("I'm focusable!")

}

private class Button : Clickable, Focusable {

    override fun onClick() {
        println("On Button Click!")
    }

    /**
     * Если класс наследует интерфейсы с одинаковыми методами,
     * Он должен явно переопределить их
     */
    override fun showOff() {
        /**
         * Получение доступа к дефолтной реализации
         */
        super<Focusable>.showOff()
        super<Clickable>.showOff()
    }
}

/**
 * Класс может быть переопределен
 */
private open class RichButton : Clickable {
    fun disable() { /* ... */
    }

    open fun animate() { /* ... */
    }

    override fun onClick() { /* ... */
    }
}

/**
 * По умолчанию можно переопределять методы с модификаторами override, open
 * Также можно переопределять методы, которые не были переопределены
 *
 */
private class ThemedButton : RichButton() {
    override fun animate() { /* ... */
    }

    override fun onClick() { /* ... */
    }

    override fun showOff() { /* ... */
    }
}