package org.example//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    println("Digita uma somba basica ae")

    val input = readln().replace(" ", "")

    if (input.contains("+")){
        val soma = input.split("+")
        println( soma[0].toInt() + soma[1].toInt())
    }else if (input.contains("-")){
        val menos = input.split("-")
        println( menos[0].toInt() - menos[1].toInt())
    }else if (input.contains("/")){
        val div = input.split("/")
        println( div[0].toInt() / div[1].toInt())
    }else if (input.contains("*")){
        val mult = input.split("*")
        println( mult[0].toInt() * mult[1].toInt())
    }

}