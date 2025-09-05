import { useState } from "react"

function Like (){

    const[contLike,setContLike] = useState(0)
    const[contDesLike,setContDeslike] = useState(0)

    function darLike(){
        setContLike(contLike + 1)
    }

    function darDeslike(){
        setContDeslike(contDesLike + 1)
    }

    return(
    <div>
        <div>
        <button onClick={darLike}>like</button>
        <button onClick={darDeslike}>deslike</button>
        </div>
        <div>
        <h2>LIKE: {contLike}</h2>
        <h2>DESLIKES: {contDesLike}</h2>
        </div>
        
    </div>
    )
}

export default Like