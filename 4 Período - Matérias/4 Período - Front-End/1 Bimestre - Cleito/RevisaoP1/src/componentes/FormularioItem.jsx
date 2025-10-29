import { useState } from "react"

export function FormularioItem ( {setListaItens, listaItens}) {

    const [item, setItem] = useState("")
    const [quantidade, setQuantidade] = useState("")
    const [precoUnidade, setPreco] = useState("")
    


    const adicionarLista = () => {

        if(item.trim() === "" || quantidade === "" || precoUnidade === "") {
            alert("preencha os campos para adicionar ao carrinho")
            return
        }

        const itensLista = {
            id : Date.now(),
            item : item,
            quantidade : quantidade,
            precoUnidade : precoUnidade,
            valorTotal : quantidade * precoUnidade
        }

        
        setListaItens([...listaItens, itensLista])
        setItem("")
        setQuantidade("")
        setPreco("")


    }

    






    return (
        <>
            <div className="divContainer">

                <input
                type="text"
                placeholder="informe o item"
                value={item}
                onChange={(item) => setItem(item.target.value)}
                ></input>

                <input
                type="number"
                placeholder="Quantidade"
                value={quantidade}
                onChange={(quantidade) => setQuantidade(quantidade.target.value)}
                ></input>

                <input
                type="number"
                placeholder="Valor unidade"
                value={precoUnidade}
                onChange={(valorUnd) => setPreco(valorUnd.target.value)}
                ></input>

                <button onClick={adicionarLista}> + </button>
            </div>
        



        </>
    )
}