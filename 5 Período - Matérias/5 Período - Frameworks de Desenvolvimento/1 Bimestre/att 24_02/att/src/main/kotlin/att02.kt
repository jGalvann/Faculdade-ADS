package org.example

fun main() {

    println("Digite o primeiro número")
    val num1 = readln().toInt()
    println("Digite o segundo numero")
    val num2 = readln().toInt()
    println("Qual é a operação que deseja dealizar?")
    println("1 - Soma \n" +
            "2 - Subtração \n" +
            "3 - Divisão \n" +
            "4 - Multiplicação\n")
     val numOperacao = readln()

    var resultado = 0
    when (numOperacao) {
        "1" -> {resultado = num1 + num2};
        "2" -> {resultado = num1 - num2};
        "3" -> {resultado = num1 / num2};
        "4" -> {resultado = num1 * num2};
    }
    println(resultado)
}