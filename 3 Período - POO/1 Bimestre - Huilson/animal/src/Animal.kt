// definicao é a representacao de alguma coisa do mundo real
// essa classe é uma superClasse
// palavra open é usada para indicar que uma classe pode ser herdada.
open class Animal() {

    // atributos da classe
    var nome: String = ""
    var especie: String = ""
    var habitat: String  = ""
    var dieta: String  = ""

    // metodos
    open fun somAnimal():String {
        return "Faz um barulho!"
    }

    /*
    ENCAPSULAMENTO
    Forma de controle sobre os atributos, quem pode ou não acessar. 

     */


    // em Kotlin nao precisa encapsular. Já em por padrão.

}