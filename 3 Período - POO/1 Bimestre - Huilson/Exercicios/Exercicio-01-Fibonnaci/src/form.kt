
/* fornulario com
nome
idade
peso
altura
depois de preencher os dados retornar o IMC

 peso / altura * altura
*/


fun calcIMC(peso: Double,altura:Double) {

    val IMC = peso / (altura * altura)
    println(IMC)

}
fun main() {

    val p = Pessoa()
    println("Informe seu nome")
    p.nome = readln()
    println("Informe sua idade")
    p.idade = readln().toInt()
    println("Informe seu peso")
    val peso = readln().toDouble()
    println("Informe sua altura")
    val altura = readln().toDouble()



    println(calcIMC(peso,altura))
}
