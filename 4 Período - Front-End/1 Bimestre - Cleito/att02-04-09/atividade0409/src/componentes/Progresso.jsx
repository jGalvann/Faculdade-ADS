import { useState } from "react"

function Progresso (){

    // obs: caso queira usar alguma var dentro de um css tem q usar o "backtip" -> ` ( fica do lado do 1)
    // permite colocar variaveis dentro de strings
    const [progresso, setProgresso] = useState(0)

    function aumentarTamanho(){
        if (progresso == 100) {
            return
        }else{
            setProgresso(progresso + 10)
        }
    }

    function diminuirTamanho (){
        if (progresso == 0) {
            return
        }else{
            setProgresso(progresso - 10)
        }
    }

    return(
        <div>  
            <div>
            <button onClick={aumentarTamanho}> + 10%</button>
            <button onClick={diminuirTamanho}> - 10%</button>
            </div>
            <div>
                <div style={{width: `${progresso}%`, height:"20px", backgroundColor:"#00ff00", marginTop:"50px"}}></div> 
            </div> 
        </div>
        
    )
}
export default Progresso