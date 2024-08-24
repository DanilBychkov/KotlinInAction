package operatorOverloadingAndOverConventions.delegates

import kotlin.reflect.KProperty

private class Delegate {

    private var _delegate: String? = null

    /**
     * Первым параметром передается тот объект, у которого запрашивается свойство,
     * а вторым — объект-описание самого свойства
     */
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        println("$thisRef, thank you for delegating '${property.name}' to me!")
        return _delegate
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
        _delegate = value
    }
}

private class Example {
    var p: String? by Delegate()
}

private fun example1() {
    val e = Example()
    println(e.p)
    //Example@533ddba, thank you for delegating 'p' to me!
    //null
    e.p = "New"
    //New has been assigned to 'p' in Example@533ddba.
}

fun main() {
    example1()
}