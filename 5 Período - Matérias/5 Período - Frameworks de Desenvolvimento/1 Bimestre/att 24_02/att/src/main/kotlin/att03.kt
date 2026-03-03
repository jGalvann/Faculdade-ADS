package org.example

import java.math.BigDecimal

fun main() {

    menu()

}

val vitrine = listOf(
    Produto("banana", BigDecimal("3.30")),
    Produto("uva", BigDecimal("0.50")),
    Produto("laranja", BigDecimal("2.50")),
    Produto("goiaba", BigDecimal("3.40")),
)



fun menu() {

    val financeiro = Financeiro()
    val estoque = Estoque()
    val compra = Compra(financeiro, estoque)
    val venda = Venda(financeiro, estoque)

    var continuar = true
    while (continuar) {

        println()
        println("1 - Comprar produto")
        println("2 - Vender produto")
        println("3 - Ver Caixa")
        println("4 - Ver estoque")
        println("5 - Sair")

        var opcao = readln().toIntOrNull()

        if (opcao == null) {
            println("Digite apenas números.")
            continue
        }

        when (opcao) {

            1 -> compra.comprar()
            2 -> venda.vender()
            3 -> financeiro.mostrarSaldo()
            4 -> estoque.mostrarEstoque()
            else -> {
                println("Saindo")
                continuar = false
            }
        }
    }
}

class Produto(
    var nome : String,
    var preco : BigDecimal,
)

class Compra(
    var financeiro: Financeiro,
    var estoque: Estoque,
){
    fun comprar(){
        println("Queres comprar oq?")

        val produtoDigitado = readln()

        val produtoLista = vitrine.find { it.nome.equals(produtoDigitado, true) }

        if (produtoLista != null) {

            if (financeiro.caixa >= produtoLista.preco) {

                financeiro.caixa = financeiro.caixa.subtract(produtoLista.preco)
                estoque.add(produtoLista)
                println("Produto comprado com sucesso")

            } else  {
                println("Denero insuficiente")
            }
        } else {
            println("Produto não existe na vitrine")
        }

    }
}

class Estoque {

    val produtos = mutableListOf<Produto>()

    fun add(produto: Produto){
        produtos.add(produto)
    }

    fun remover(nome: String): Produto? {
        val produto = produtos.find { it.nome.equals(nome, true) }

        if (produto != null) {
            produtos.remove(produto)
            return produto
        }

        return null
    }

    fun mostrarEstoque() {
        if (produtos.isEmpty()) {
            println("Tem nada no estoque")
        } else {
            println("Prodotos em estoque:")
            produtos.forEach {
                println("- ${it.nome}")
            }
        }

    }

}

class Venda(
    var financeiro: Financeiro,
    var estoque: Estoque,

) {

    fun vender(){

        println("Qual produto deseja vender? ")
        val produtoDigitado = readln()

        println("Quantas unidades deseja vender?")
        val quantidade = readln().toInt()

        var totalVenda = BigDecimal.ZERO
        var vendidos = 0

        repeat(quantidade) {

        val produtoRemovido = estoque.remover(produtoDigitado)

        if (produtoRemovido != null) {

           val precoFinal = produtoRemovido.preco.multiply(BigDecimal("1.05"))

          totalVenda = totalVenda.add(precoFinal)
          vendidos ++


        } else {
            println("Estoque insuficiente de $produtoDigitado")
            return@repeat
        }
    }
        if (vendidos > 0) {

            financeiro.caixa = financeiro.caixa.add(totalVenda)
            println("Venda realizada com sucesso, em um total de: R$ $totalVenda")

        }
    }
}

class Financeiro(
    var caixa : BigDecimal = "100.00".toBigDecimal(),
) {
    fun mostrarSaldo(){
        println("Saldo no momento:")
        println("R$ ${caixa} ")
    }
}