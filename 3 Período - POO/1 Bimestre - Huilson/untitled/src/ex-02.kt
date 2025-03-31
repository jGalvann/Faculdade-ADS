fun main() {

    println("escolha um numero")
    var numero = readLine()!!.toInt()
    var ehPrimo = true
    if (numero <= 1) {
        ehPrimo = false
    } else  {
        for (i in 2 until numero) {
            if ( numero % i == 0 ) {
                ehPrimo = false
                break
            }

        }
    }
    if (ehPrimo) {
        println("$numero é um numero primo")
    }else   {
        println("$numero nao é primo")
    }

}