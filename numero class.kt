interface IBaseNumber {
    val value: Int
    fun printValue()
}

class PrimeNumber(override val value: Int) : IBaseNumber {
    init {
        require(value > 1) { "El número primo debe ser mayor que 1" }
    }

    override fun printValue() {
        println("Número primo: $value")
    }
}

class OddNumber(override val value: Int) : IBaseNumber {
    val divisors: List<Int> = calculateDivisors()

    init {
        require(value % 2 != 0) { "El número impar debe ser impar" }
    }

    override fun printValue() {
        println("Número impar: $value")
        println("Divisores: $divisors")
    }

    private fun calculateDivisors(): List<Int> {
        return (1..value).filter { value % it == 0 }
    }
}

class EvenNumber(override val value: Int) : IBaseNumber {
    val divisors: List<Int> = calculateDivisors()

    init {
        require(value % 2 == 0) { "El número par debe ser par" }
    }

    override fun printValue() {
        println("Número par: $value")
        println("Divisores: $divisors")
    }

    private fun calculateDivisors(): List<Int> {
        return (1..value).filter { value % it == 0 }
    }
}