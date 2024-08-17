package workingWithNullableValues.inheritance

/**
 * При наследовании Java интерфейсов в Kotlin коде
 * реализация может содержать как nullable параметры,
 * так и не nullable параметры в случае если тип параметра не был явно указан
 * с помощью аннотаций @Nullable и @NotNull.
 */

private class StringPrinter : StringProcessor {

    override fun process(value: String) {
        println(value)
    }
}

private class NullableStringPrinter : StringProcessor {

    override fun process(value: String?) {
        if (value != null) {
            println(value)
        }
    }
}

