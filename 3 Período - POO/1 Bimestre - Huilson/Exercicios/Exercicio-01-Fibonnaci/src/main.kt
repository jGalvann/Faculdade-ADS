

fun main() {
    val regex = Regex("^(?:[2*9]|\\d{2,})$")
    var num: String

    do {
        println("Digite uma casa da sequncia de fibonacci")
        num = readln()
    }while (!regex.matches(num))

    println(fibonacci(num.toInt()))
}