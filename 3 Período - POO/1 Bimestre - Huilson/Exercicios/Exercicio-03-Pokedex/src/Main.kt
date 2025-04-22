import TipoPokemon
import Efetividade
import Pokemon



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