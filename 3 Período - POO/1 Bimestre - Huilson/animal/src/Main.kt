fun main() {

    var gato: Gato = Gato()
        gato.nome = "gato"
        gato.habitat = "domestico"
        gato.especie = "felino"
        gato.dieta = "peixe"

        println(gato.somAnimal())

    /*
        nao é legal fzr isso
        val gato : Gato = gato as Gato
     */

    var cachorro = Cachorro()
    cachorro.nome = "Cachorro"
    cachorro.habitat = "domestico"
    cachorro.especie = "canino"
    cachorro.dieta = "carne moida"

    println(cachorro.somAnimal())

    val animal = Animal()
    println(animal.somAnimal())

    /*
    toda classe começa com letra maiúscula
    e seque o padrao CamelCase
    ** MinhaClasse

    os objetos comecam com letra MINUSCULA
    ex: meuObj
     */

}