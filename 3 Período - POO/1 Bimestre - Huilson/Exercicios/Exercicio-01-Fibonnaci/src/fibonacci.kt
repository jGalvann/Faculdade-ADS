// f(n) = f(n-1) + f(n-2)
// formula de fibo

fun fibonacci(n: Int): Int {
    if  ( n <= 1) {
        return n
    }
    return fibonacci(n-1) + fibonacci(n-2)

}


fun main() {

    println("Digite uma casa da sequencia de fibonacci")
    val num = readln().toInt()
   println(fibonacci(num))


}