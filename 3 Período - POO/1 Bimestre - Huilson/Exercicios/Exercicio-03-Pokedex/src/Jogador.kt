class Jogador ( val nome: String, var timePokemon: MutableList<Pokemon>) {


    fun addPokemon(pokemon: Pokemon) {
        if (timePokemon.size < limitePokemonTime) {
            timePokemon.add(pokemon)
            println("O ${pokemon.nome} foi adicionado ao time de $nome")
        } else {
            println("Time cheio, não se pode mais add pokemon")
        }
    }

// não estou usando
    fun removerPokemon(pokemon: Pokemon) {
        if (timePokemon.size > 1) {
            timePokemon.remove(pokemon)
            println("${pokemon.nome} foi removido do time de $nome.")
        } else {
            println("Seu time não possui pokémons suficientes para remover!")
        }
    }

// não ta usando tbm
    fun mostrarTime() {
        println("Time de $nome ")
        if (timePokemon.isEmpty()){
            println("O time se encontra vazio ")
        } else {
            for (pokemon in timePokemon) {
                println(" - ${pokemon.nome} do tipo ${pokemon.tipoPrimario} / ${pokemon.tipoSecundario}")
            }
        }
    }
}

