fun main() {
    val range = 1..100 
    val processor = PrimeNumberProcessor(range) 
    val evaluationResult = processor.evaluateNumbers() 
    println("Resultados de la evaluación:")
    
    println("\nNúmeros Primos:")
    evaluationResult.primeNumbers.forEach { it.printValue() }
    
    println("\nNúmeros Pares:")
    evaluationResult.evenNumbers.forEach { it.printValue() }
    
    println("\nNúmeros Impares:")
    evaluationResult.oddNumbers.forEach { it.printValue() }
}