package generics.andOperator

private interface Storage<T> {

    fun get(): T

    fun put(o: T & Any)
}

private class StorageImpl : Storage<String?> {

    private var _o: String? = null

    override fun put(o: String) {
        _o = o
    }

    override fun get(): String? {
        return _o
    }
}