fun main() {


    var nota = 0.0
    val qntProvas = 3

    for (i in 1..qntProvas) {

        println("Digite a nota")
        nota += readLine()!!.toInt()

    }
    var mediaNota :Double = nota/ 3


    if (mediaNota >= 7) {
        println("Aprovado")
    }else if (mediaNota >= 5) {
        println("Recuperacao")
    }else{
        println("Reprovado")
    }

    println("Media nota $mediaNota")



}