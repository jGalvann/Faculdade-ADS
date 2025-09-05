import { useState } from "react"

function ConversorTemperatura (){

    const [celsos, setCelso] = useState(0)
    const [tempDeIdiota,setTemp2 ] = useState(0)
    
    function conversorTemp(event){ // lembrar dessa parada aqui
        const temp = event.target.value // sempre esqueço q tem q usar o evento como parametro
        setCelso(temp)
        setTemp2( (temp * 9/5) + 32)
    }

    return(
        <div>  
            <p> Digite a temperatura em Celsos:</p>
            <input onChange={conversorTemp}></input>

            <p>Sua temperatura em Celsos é de: {celsos} </p>
            <p>Mas, em Fahrenheight seria de: {tempDeIdiota}</p>
        </div>
    )
}
export default ConversorTemperatura