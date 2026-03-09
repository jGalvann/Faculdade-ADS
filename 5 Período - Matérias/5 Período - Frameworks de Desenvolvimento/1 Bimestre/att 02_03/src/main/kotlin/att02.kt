fun main() {

    /*
    main()
 1 - lerExpressao()

 2 - validarExpressao()
        (mínimo 9 caracteres)

 3 - tokenizarExpressao()

 4 - resolverParenteses()

 5 - resolverMultiplicacaoDivisao()

 6 - resolverSomaSubtracao()

 7 - mostrarResultado()
*/

    println("Digite uma expressão com no minimo 9 caracteres!")
    var input = readln().replace(" ", "")

    if (input.length < 9 ) {
        println("A expressão deve ter mais de 9 caracteres.")
        return
    }

    var numLista = mutableListOf<String>()
    var numAtual = ""

    for (c in input) { // transformar em lista pra trabaia com pilha

        if(c.isDigit()) {   //  pro 12 não virar 1 e 2
            numAtual += c
        }else {

            if (numAtual != "") {
                numLista.add(numAtual)
                numAtual = ""
            }

            numLista.add(c.toString())
        }
    }
    if (numAtual != "") {
        numLista.add(numAtual)
    }

    

}