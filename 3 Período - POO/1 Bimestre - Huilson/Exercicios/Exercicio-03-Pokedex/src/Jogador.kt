class Jogador ( val nome: String, var timePokemon: MutableList<Pokemon>) {


    fun addPokemon(pokemon: Pokemon) {
        if (timePokemon.size < limitePokemonTime) {
            timePokemon.add(pokemon)
            println("O ${pokemon.nome} foi adicionado ao time de $nome")
        } else {
            println("Time cheio, não se pode mais add pokemon")
        }
    }


    fun mostrarTime() {

    timePokemon.forEachIndexed { index, pokemon ->
        println("${index + 1}. ${pokemon.nome} (${pokemon.tipoPrimario}${if (pokemon.tipoSecundario != null) 
            ", ${pokemon.tipoSecundario}" else ""})")

            }
        }
    }

