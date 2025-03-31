
fun main() {

    var jogadorUm : String
    var jogadorDois : String

    do {
        println("Qual o nome do jogador 1?")
        jogadorUm = readLine()!!
        println("Qual o nome do jogador 2?")
        jogadorDois = readLine()!!
        if (jogadorUm.isBlank() || jogadorDois.isBlank() ) {
            println("Coloca um nome né querido")
        }
    }while (jogadorDois.isBlank() && jogadorUm.isBlank())


    val numeroAleatorioJ1 = (1..100).random()
    val numeroAleatorioJ2 = (1..100).random()
    var tentativasJogador1 = 0
    var tentativasJogador2 = 0
    var continuar = true
    var chute : Int

    while (continuar) {

        println("$jogadorUm, qual seu chute?")
        chute = readLine()!!.toInt()

        when {
             chute < numeroAleatorioJ1 -> {println("numero escolhido é maior")
                                            tentativasJogador1++ }
            chute > numeroAleatorioJ1 -> {println("numero escolhido é menor ")
                                            tentativasJogador1++ }
            else -> {
                tentativasJogador1++
                println("Acertou 🥳 com $tentativasJogador1 tentativas")
                continuar = false
                    }
        }

    }

    continuar = true

while (continuar) {

    println("$jogadorDois, qual seu chute?")
    chute = readLine()!!.toInt()

    when {
        chute < numeroAleatorioJ2 -> {println("numero escolhido é maior")
            tentativasJogador2++ }
        chute > numeroAleatorioJ2 -> {println("numero escolhido é menor ")
            tentativasJogador2++ }
        else -> {
            tentativasJogador2++
            println("Acertou 🥳 com $tentativasJogador2 tentativas")
            continuar = false
        }
    }

 
}

    for (i in 1..5){
        println("\n")
    }
    println("\nResultado Final:")
    println("$jogadorUm fez $tentativasJogador1 tentativas")
    println("$jogadorDois fez $tentativasJogador2 tentativas")
// --------
    when {
        tentativasJogador1 < tentativasJogador2 -> println("$jogadorUm ganhou!")
        tentativasJogador2 < tentativasJogador1 -> println("$jogadorDois ganhou!")
        else -> println("Empate!")
    }
}