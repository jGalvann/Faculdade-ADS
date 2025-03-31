

   // funcao para pegar um valor aleatório
   // totalmente desneceessária. mas queria ver como funcionava funcao em kt
    fun escolhaJogo() : String {

        val opcoes = listOf("Pedra", "Papel", "Tesoura")
        return opcoes.random()

}
   // fun para comparar as escolhas do jogador e da maquina.
    fun compararEscolhas(maquina: String, user: String): String {
            var estado: String
            when (user) {
                    "Pedra" -> {
                            estado = when (maquina) {
                                    "Pedra" -> "Empate"
                                    "Papel" -> "Perdeu"
                                    "Tesoura" -> "Ganhou"
                                    else -> "Resultado inválido"
                            }
                    }
                    "Papel" -> {
                            estado = when (maquina) {
                                    "Pedra" -> "Ganhou"
                                    "Papel" -> "Empate"
                                    "Tesoura" -> "Perdeu"
                                    else -> "Resultado inválido"
                            }
                    }
                    "Tesoura" -> {
                            estado = when (maquina) {
                                    "Pedra" -> "Perdeu"
                                    "Papel" -> "Ganhou"
                                    "Tesoura" -> "Empate"
                                    else -> "Resultado inválido"
                            }
                    }
                    else -> {
                            estado = "Escolha inválida"
                    }
            }
            return estado
    }



    fun main() {
        var contadorMaquina = 0
        var contadorJogador = 0
        var continuarJogo = true
        do {
                println("----------------------------")
                println("Escolha entre:")
                println("1 - Pedra")
                println("2 - Papel")
                println("3 - Tesoura")
                println("----------------------------")

                // escolha da maquina. chama a fun e aloca na var
                var escolhaMaquina = escolhaJogo()
                // leitura da escolha do jogador
                var escolhaJogador : Int
                do { // checando se o imbecil n ta fzndo coisa errada
                    escolhaJogador = readLine()!!.toInt()
                        if(escolhaJogador !in 1..3){
                                println("escolha um numero valido")
                                println("1 - Pedra")
                                println("2 - Papel")
                                println("3 - Tesoura")
                        }
                }while (escolhaJogador !in 1..3)


                // mudando o tipo de dado da escolha do jogador.
                // para poder comparar com a escolha da maquina.
                val opcaoJogador :String = when (escolhaJogador) {
                        1 -> "Pedra"
                        2 -> "Papel"
                        3 -> "Tesoura"
                        else -> "Erro"
                }


                var resultado = compararEscolhas(opcaoJogador, escolhaMaquina)
                println("Resultado $resultado:")

                if (resultado == "Ganhou") {
                        contadorJogador++
                }else if (resultado == "Perdeu") {
                        contadorMaquina++
                }

                println("Maquina: $contadorMaquina")
                println("Jogador: $contadorJogador")



                println("Deseja continuar?")
                println("1 - sim")
                println("2 - nao")

                var continuar : Int
                do {
                    continuar = readLine()!!.toInt()
                        if (continuar != 1 && continuar != 2 ){
                                println("Escolha entre 1 e 2 colega")
                        }
                }while (continuar != 1 && continuar != 2)


                if (continuar == 1) {
                        continuarJogo = true
                }else if (continuar == 2) {
                        continuarJogo = false
                }else  {
                        println("escolha entre uma das opcoes validas")
                }


        }while (continuarJogo)

}




