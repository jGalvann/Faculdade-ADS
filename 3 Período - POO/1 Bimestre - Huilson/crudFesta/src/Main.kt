val expressaoRegular = Regex("[0-5]")

// instância de uma lista mutável vazia.
var listaConvidados : MutableList<Convidado> = mutableListOf<Convidado>()
fun main() {

    menu()


}

private fun menu() {

    do {
        println("---MENU---")
        println("1- CADASTRAR")
        println("2- LISTAR")
        println("3- EDITAR")
        println("4- EXCLUIR")
        println("5- BUSCAR")
        println("0- SAIR")

        val opcao = readln()// precisa ser string por causa do REGEX
        if(expressaoRegular.matches(opcao)) {
            when (opcao.toInt()) {

                1 -> {
                    println("Cadastrando...")
                    cadastrar()
                }
                2 -> {
                    println("Listando...")
                    listar()
                }
                3 -> {
                    println("Editando...")
                    editar()
                }
                4 -> {
                    println("Excluindo...")
                    excluir()
                }
                5 -> {
                    println("Buscando")
                    busca()
                }
                0 -> print("SAINDO...")
            }
        }else {
            println("\n\n\nOpção Invalida!\n")
        }
    } while (opcao != "0")
}

private fun cadastrar() {
    // explicando o REGEX
    // primeira parte [A-ZÀ-ÖØ-Ÿ]
    // verifica se a letra é maiuscula. A-ZÀ-:Y
    // o ÖØ é para nao contar ç \ letras minusculas com acento \ como primeiro char.
    val regex = Regex("^[A-ZÀ-ÖØ-Ÿ][a-zà-ÿ ]+$")
    var nome: String
    // instancia
    val convidado = Convidado()
    do {
        println("Qual o seu nome? ")
        nome = readln()

        if (regex.matches(nome)) {
        convidado.nome = nome

        } else {

            println("Nome Invalido!")
            println("O nome deve conter a primeira letra MAIUSCULA \n" +
                    "e somente letras.")
        }



    }while (!regex.matches(nome))


    println("Qual sera seu presente?")
    convidado.presente = readln()

    println("Qual sua restrição alimentar? ")
    convidado.alimentar = readln()

    listaConvidados.add(convidado)


}

private fun listar(){
var i = 0

    if (validar()) {

        listaConvidados.forEach { convidado ->
            println(
                "-------------------------------------------\n" +
                "Posição: ${i++} \n"+
                "Nome: ${convidado.nome}; \n" +
                        "Presente: ${convidado.presente}; \n"  +
                        "Restrição: ${convidado.alimentar}; \n" +
                        "Vai ir a festa? ${convidado.presenca}\n" +
                        "-------------------------------------------\n"

            )
        }
    }
}

// questao 2 - validar que a posicao seja sempre numerica
// e a variavel resposta, seja sempre s/n ( string s/n )

private fun editar() : Boolean {
    if (validar()) {
        val regexNum = Regex("[0-9]")
        val regexResposta = Regex("^[sSnN]$")
        var posicao : String


        do {
            println("Digite a posição a ser editada")
            posicao = readln()


            if (regexNum.matches(posicao)) {

                if (posicao.toInt() in listaConvidados.indices) {
                    println("O convidado vai? S/N")
                    val resposta = readln()

                    if (regexResposta.matches(resposta)) {
                        when (resposta.uppercase()) {
                            "S" -> listaConvidados[posicao.toInt()].presenca = true
                            "N" -> listaConvidados[posicao.toInt()].presenca = false

                        }
                        return true
                    } else {
                        println("Coloque uma resposta válida")
                    }
                } else {
                    println("Posição inválidade, ela não existe na lista!")
                }
            }else {
                println("Posição inválida, não é um número")
            }
        }while (true)

    }
    return false
}

// questao 3 - só pode digitar numeros.

private fun excluir(): Boolean {
    if (validar()) {

        listar()

        println("Quem deseja remover?")
        val posicao = readln().toInt()
        listaConvidados.removeAt(posicao)
        println("Convidado excluido")
        return true
    }
    return false
}

// questao 4 -  só pode entrar letras na busca
// e ignorar letrar maiusculas // minusculas

private fun busca() :Boolean {
    var i = 0 // indice da lista
    println("Digite o nome da pessoa que voce quer fazer a busca")
    val busca = readln()

    listaConvidados.forEach { convidado ->
       if( convidado.nome.contains(busca)){
           println("Posição $i, Nome: ${convidado.nome} vai para a festa")

           return true
       }
       i++
    }
    println("A pessoa $busca, não vai para a festa")
    return false

}

private fun validar() : Boolean {
    // se estiver vazio == falso

 if(listaConvidados.isEmpty()) {
     println("A lista esta vazia! Finalizando...")
     return false
 }
    return true
 }


/*
    Entendimento do REGEX
    criando -> val nomeRegex = Regex("pattern") -> cria a expressao regular
    ou -> val nomeRegex = "pattern".toRegex() -> converte diretamente a string em um obj regex

Funcionamento
    Basico:
     - val regex = Regex("oi")
     - val texto = "oi, como vai?"
     se usar um contains, sai true.

     Metacaracteres:
     ( . ) - > match char menos nova linha
     ( ^ ) -> match o inicio da linha
     ( $ ) -> match o final da linha
     ( * ) -> match 0 ocorrencias ou mais do elemento
     ( + ) -> match 1 ou mais ocorrencias do mesmo elemento
     ( ? ) -> match 0 ou 1 ocorrencias de um elemento
     ( [ ] ) -> define a classe de um character

     Avançado:
     ( [a-z] ) -> letras minusculas
     ( [A-Z] ) -> letras maiusculas
     ( [0-9] ) -> qualquer num
     ( \\D ) -> qualquer num ( msm coisa de 0-9 )
     ( \\w ) -> qualquer caracter palavra
     ( \\W ) -> qualquer caracter nao palavra



 */