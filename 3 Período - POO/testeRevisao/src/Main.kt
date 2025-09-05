fun main(){
    val exemplo = mapOf(
        "nome" to "Joãozinho",
        "idade" to 21,
        "aprovado" to false,
        "media final" to 8.33
    )

    if(exemplo["media final"].toString().toDouble() > 6.0){
        println("Aprovado!")
        exemplo["aprovado"] = true
    }else{
        println("Reprovado!")
        exemplo["aprovado"] = false
    }
}