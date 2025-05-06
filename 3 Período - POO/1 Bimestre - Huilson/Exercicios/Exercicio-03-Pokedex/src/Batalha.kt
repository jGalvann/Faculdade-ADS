class Batalha(val jogador1: Jogador, val jogador2: Jogador) {

    var pokemonEmCampoJ1: Pokemon? = null
    var pokemonEmCampoJ2: Pokemon? = null
    var turno = 1

















    


    private fun verificarTime():Boolean{
        if (jogador1.timePokemon.isEmpty()){
            println("o jogador: ${jogador1.nome} não possui pokemons no time")
            return false
        }
        if (jogador2.timePokemon.isEmpty()){
            println("o jogador: ${jogador2.nome} não possui pokemons no time")
            return false
        }

        return true
    }

    private fun iniciarBatalha(){

        if (!verificarTime()) return



    }




}