import { useState } from "react"

function Votacao (){

    const [votoA, setA] = useState(0)      
    const [votoB, setB] = useState(0)    
    const [votoC, setC] = useState(0)    
    
    function addVotoA(){
        setA(votoA + 1)
    }
    function addVotoB(){
        setB(votoB + 1)
    }
    function addVotoC(){
        setC(votoC + 1)
    }

    function maisVotado(){
        
    }

    return(
    <div>
        <div><h1>VOTE!</h1></div>
        <div>
        <button onClick={addVotoA}>Opção A</button>
        <button onClick={addVotoB}>Opção B</button>
        <button onClick={addVotoC}>Opção C</button>
        </div>
        <div>
        <h2>VOTOS A:{votoA} | VOTOS B:{votoB} | VOTOS C:{votoC} </h2>
        
        </div>
        
    </div>
    )
}
export default Votacao