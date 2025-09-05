import { useState } from "react"

function Carrinho (){

    const [qntItem, setItem] = useState(1)
    const [precosItens, setPreco] = useState(50.00)

    function addItem() {
        setItem(qntItem + 1)
        setPreco(precosItens + 50.00)
    }

    function rmvItem(){
        if (qntItem == 1){
            return
        }else {
            setItem(qntItem - 1 )
            setPreco(precosItens - 50.00)
        }
    }
    return(
        <div>  
    
            <div>
                <h3>ITENS CARRINHO: {qntItem}</h3>
                <h3>PREÇO ITENS: R$ {precosItens}</h3>
            </div>
            <div>
            <button onClick={addItem}>ADICIONAR ITEM</button>
            <button onClick={rmvItem}>REMOVER ITEM</button>
            </div>
        </div>
    )
}
export default Carrinho