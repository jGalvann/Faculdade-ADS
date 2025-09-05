import { useState } from "react"

function ControleNota (){

    const [nome, setNome] = useState("aguardando nome")
    const [nota, setNota] = useState("aguardando notas")
    const [estado, setEstado] = useState("")


    function addNota(event) {
    const valor = event.target.value
    setNota(valor)
    if (valor >= 7) {
        setEstado("Aprovado")
    } else {
        setEstado("Reprovado")
    }
}
    
    function addNome(){
        setNome(event.target.value)
    }

  

    return(
        <div>  
            <div>
            <p>NOME ALUNO</p>
            <input onChange={addNome}></input>
            <p>NOTA ALUNO</p>
            <input onChange={addNota}></input>
            </div>
            <div>
                <p>Nota: {nota} | Nome:  {nome}</p>
                <p> {estado} </p>
            </div>
        </div>
    )
}
export default ControleNota