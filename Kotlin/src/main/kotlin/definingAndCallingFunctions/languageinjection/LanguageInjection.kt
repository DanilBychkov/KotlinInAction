package definingAndCallingFunctions.languageinjection

import org.intellij.lang.annotations.Language

/**
 * Пример Language Injection
 */
@Language("JSON")
val expectedObject: String = """
    {
       "name": "Sebastian",
        "age": 27,
        "homeTown": "Munich"
    }
""".trimIndent()