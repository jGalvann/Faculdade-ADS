// cria essa parada como var global para poder usar nas func
val nomes = mutableListOf<String>()

fun main() {
    // para validar a entrada
    val regex = Regex("[0-4]")

    do {

    println("O que deseja fazer?")
    println("1 - Adicionar nome na lista")
    println("2 - Remover o nome na lista")
    println("3 - Listar nomes")
    println("4 - Sair")
    val opcao = readln()

    if (opcao.matches(regex)) {

        when (opcao.toInt()) {

            1 -> adicionarNome()

            2 -> removerNome()

            3 -> listaNomes()

        }

    } else{
        println("Escolha uma opção válida!")
    }



    }while (opcao != "4" )



}


private fun adicionarNome() {
    // regex aqui aceita letras | letras com acento | espaço ( nome composto )
    val regex = Regex("^[a-zA-Zà-ÿ ]+$")

    do {

        println("Qual nome deseja adicionar?\n")
        val nomeAdd = readln()
        // valida o nome
        if (nomeAdd.matches(regex)) {
            // add na mutablelist
            nomes.add(nomeAdd)
            println("O nome $nomeAdd foi adicionado com sucesso!\n")
        } else {
            println("Insira um nome válido!")
        }

    }while (!regex.matches(nomeAdd))
}

private fun removerNome() {

    // n to validando entrada nesse, pq já foi validada em outra etapa, e se alguem tentar colocar qualquer parada aq
    // só n vai existir na lista msm
    println("Qual nome deseja remover?\n")
    val nomeComparacao = readln()

    // aqui pega e comparada cada elemento ignorando a diferença entre maiuscula e minuscula
    if (nomes.any {it.equals(nomeComparacao, ignoreCase = true)}){
        nomes.remove(nomeComparacao)
        // aparentemente o kotlin reorganiza o array pa nois
        println("O nome $nomeComparacao foi removido da lista.\n")

    }else {
        println("Este nome não existe na lista. Tente reescreve-lo ou tente outro.\n")
    }

}

private fun listaNomes() {

    var i = 1
    nomes.sort()
    for (nome in nomes){
        println("$i.$nome")
        i++
    }

}
