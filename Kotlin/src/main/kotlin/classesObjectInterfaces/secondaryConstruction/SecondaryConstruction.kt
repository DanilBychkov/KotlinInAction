package classesObjectInterfaces.secondaryConstruction

import java.net.URI

private open class Downloader {
    constructor(url: String?)

    constructor(uri: URI?)
}

/**
 * Если мы наследуемся от класса в котором определены конструкторы,
 * то нужно переопределить хотя бы один из этих конструкторов
 */
private class MyDownloader : Downloader {

    constructor(url: String?) : this(URI(url))

    constructor(uri: URI?) : super(uri)
}

