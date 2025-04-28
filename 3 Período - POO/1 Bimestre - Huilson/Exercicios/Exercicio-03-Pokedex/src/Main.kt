import TipoPokemon
import Efetividade
import Pokemon

const val limitePokemonTime = 6
val jogadores = mutableListOf<Jogador>()


fun main() {
    do {

        println("== MENU == ")
        println("-- 1 - Catalogar jogador --  ") // fiz a func que cria o obj
        println("-- 2 - Catalogar Time -- ") // criar uma func que add na mutableList do obj
        println("-- 3 - Remover pokemon --  ") // remover da mtblist
        println("-- 4 - Iniciar batalha  --  ") // escolher 2 jogadores, e começar o duelo de acordo com oq o professor passou
        println("-- 5 - Listar Jogadores  --  ") // mostra o jogador ( nome e lista o time )
        println("-- 0 - Sair -- ")

        val opcao = readln()
        when(opcao.toInt()) {

            1 -> {
                val jogador = cadastrar()
                jogadores.add(jogador) // deixa guardado o novo jogador na memória.
                println("o jogador ${jogador.nome} foi cadastrado com sucesso")
            }


        }



    }while (opcao != "0" )






}

private fun cadastrar() : Jogador{

    val regex = Regex("^[A-ZÀ-ÖØ-Ÿ][a-zà-ÿ ]+\$") // primeira letra maiuscula, e sem numeros, para o nome
    var nome: String

    do{
        println("Qual o nome do jogador?")
        nome = readln()

        if (!regex.matches(nome)){
            println("Coloque um nome valido para o jogador")
        }


    } while (!regex.matches(nome))

    val jogador = Jogador(nome, mutableListOf())

    return jogador
}



/*
 aqui tinha sido do primeiro trabalho. ( não havia sido pedido esta parte. )

fun main() {
    val efetividade = Efetividade()

    print("Digite o nome do Pokémon que você quer buscar: ")
    // esse "?" depois do readln... é para n dar merda qndo for null
    val nomePokemon = readlnOrNull()?.lowercase() // lower pq usei nome em minusculo como chave

    if (nomePokemon != null && Pokemon.todosPoke.containsKey(nomePokemon)) { // se n for nulo e existir no map todosPoke -> executa
        val pokemonEncontrado = Pokemon.todosPoke[nomePokemon]!!
        val tipoPokemon = if (pokemonEncontrado.tipoSecundario != null) { // checa se tem 2 tipos
            pokemonEncontrado.tipoPrimario.toString() + " e " + pokemonEncontrado.tipoSecundario.toString()// caso tenha, concatena os 2 em uma string

        } else {
            pokemonEncontrado.tipoPrimario.toString()
        }
        val vantagensDoTipoPrimario = listOf( efetividade.vantagens[pokemonEncontrado.tipoPrimario])
        val vantagensDoTipoSecundario = listOf( efetividade.vantagens[pokemonEncontrado.tipoSecundario])



        println("\nInformações do Pokémon:")
        println("Nome: ${pokemonEncontrado.nome }") // como cada pokemon é uma classe aq pega o nome dele
        println("ID: ${pokemonEncontrado.numPokedex}")
        println("Tipo(s): $tipoPokemon")
        println("Vantagens contra os tipos: ${vantagensDoTipoPrimario.joinToString()} ${vantagensDoTipoSecundario.joinToString()}") // caso n tenha tipo secundário print um null e é isso aí msm

    } else {
        println("\nPokémon não encontrado na Pokédex.")
    }
}

 */