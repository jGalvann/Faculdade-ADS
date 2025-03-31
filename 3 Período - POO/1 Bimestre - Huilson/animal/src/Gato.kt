/* Herança:
    Permite que uma classe herde todos os atributos e metodos de uma outra classe
    essa classe é uma subclasse
 */
class Gato: Animal(){
    val higiene: String = "Usa caixa de areia"

    // o somAnimal já tem um valor na outra classe, usar o override faz sobrescrever o valor.
    override fun somAnimal() : String {
        return "wa wa wa"
    }

    /*
    POLIMORFISMO:
    é uma forma de sobrescrever métodos de uma superclasse
     */
}