package basicTypes.inheritance

/**
 * При наследовании Java интерфейсов в Kotlin
 * требуется самому определять тип списка: MutableList or List
 * т.к. в Java нет разделение типов списка
 */

private class MutableFileProcessorImpl : FileProcessor {

    override fun process(textContents: MutableList<String>?) {

    }
}

private class FileProcessorImpl : FileProcessor {

    override fun process(textContents: List<String>) {

    }
}