data class EvaluationResult(
    val primeNumbers: MutableList<PrimeNumber> = mutableListOf(),
    val oddNumbers: MutableList<OddNumber> = mutableListOf(),
    val evenNumbers: MutableList<EvenNumber> = mutableListOf()
)

class PrimeNumberProcessor(private val range: IntRange) {
    fun evaluateNumbers(): EvaluationResult {
        val result = EvaluationResult()
        for (number in range) {
            when (validateNumber(number)) {
                NumberType.PRIME -> result.primeNumbers.add(PrimeNumber(number))
                NumberType.ODD -> result.oddNumbers.add(OddNumber(number))
                NumberType.EVEN -> result.evenNumbers.add(EvenNumber(number))
            }
        }
        return result
    }

    private fun validateNumber(number: Int): NumberType {
        return when {
            isPrime(number) -> NumberType.PRIME
            number % 2 == 0 -> NumberType.EVEN
            else -> NumberType.ODD
        }
    }

    private fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) return false
        }
        return true
    }
}

enum class NumberType {
    PRIME, ODD, EVEN
}