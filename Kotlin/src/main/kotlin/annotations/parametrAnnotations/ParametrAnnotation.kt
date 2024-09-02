package annotations.parametrAnnotations

import kotlin.reflect.KClass

private annotation class DeserializeInterface(val targetClass: KClass<out Any>)

private interface Company {
    val name: String
}

private data class CompanyImpl(override val name: String) : Company

private data class Person(
    val name: String,
    @DeserializeInterface(CompanyImpl::class) val company: Company
)