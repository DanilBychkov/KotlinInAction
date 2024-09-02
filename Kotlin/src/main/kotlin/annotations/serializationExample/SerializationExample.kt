package annotations.serializationExample

import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

interface ValueSerializer<T> {
    fun toJsonValue(value: T): Any?
    fun fromJsonValue(jsonValue: Any?): T
}

class IntSerializer : ValueSerializer<Int> {
    override fun toJsonValue(value: Int): Any {
        return "Int[$value]"
    }

    override fun fromJsonValue(jsonValue: Any?): Int {
        TODO("Not yet implemented")
    }

}


//https://discuss.kotlinlang.org/t/finding-field-annotations-using-obj-class-declaredmemberproperties/8497
@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude()

@Target(AnnotationTarget.PROPERTY)
annotation class JsonName(val name: String)

@Target(AnnotationTarget.PROPERTY)
annotation class CustomSerializer(
    val serializerClass: KClass<out ValueSerializer<*>>
)

data class PersonSerialization(
    @JsonName(name = "PersonName") val firstName: String,
    @JsonExclude val lastName: String,
    @CustomSerializer(IntSerializer::class) val age: Int,
)


fun serialize(obj: Any): String = buildString { serializeObject(obj) }

private fun StringBuilder.serializeObject(x: Any) {
    val kClass = x.javaClass.kotlin
    val properties = kClass.memberProperties
    val filteredProperties = properties.filter { prop -> prop.findAnnotation<JsonExclude>() == null }

    append("{ ")

    filteredProperties.forEachIndexed { index, prop ->
        val name = prop.findAnnotation<JsonName>()?.name ?: prop.name
        append(name)
        append(": ")
        val value = prop.get(x)
        val jsonValue = prop.getSerializer()?.toJsonValue(value) ?: value
        append(jsonValue)
        if (index != filteredProperties.size - 1) {
            append(", ")
        }
    }

    append(" }")
}

@Suppress("UNCHECKED_CAST")
private fun KProperty<*>.getSerializer(): ValueSerializer<Any?>? {
    val customSerializerAnn = findAnnotation<CustomSerializer>() ?: return null
    val serializerClass = customSerializerAnn.serializerClass

    val valueSerializer = serializerClass.objectInstance ?: serializerClass.createInstance()

    return valueSerializer as ValueSerializer<Any?>
}

fun main() {
    val person = PersonSerialization("Danil", "Bychkov", 28)
    println(serialize(person))
}

