export function ListaItens ({itens, setListaItens}) {

    const removerItem = (id) => {
        setListaItens(itens.filter(log => log.id !==id))
        
    }

    const valorTotalSomado = itens.reduce((flagSoma, item ) => flagSoma + item.valorTotal, 0)
    return(
        <>
            <div className="mostrarCoisa">
            <div className="cabecalhoLista">
                <p>Item</p>
                <p>Quantidade</p>
                <p>Unidade</p>
                <p>Total</p>
                <p>Ações</p>
            </div>
            <div>
                <ul>
                    {itens.map((log) => (
                        <li key={log.id}>
                            <p>{log.item}</p>
                            <p>{log.quantidade}</p>
                            <p> R$ {Number(log.precoUnidade).toFixed(2)}</p>
                            <p> R$ {Number(log.valorTotal).toFixed(2)}</p>
                            <button onClick={() => removerItem(log.id)}> ❌ </button>
                        </li>
                    ))}
                </ul>
            </div>
            <div>
                <strong>Total Geral: R$ {valorTotalSomado.toFixed(2)}</strong>
            </div>
            </div>

        </>
    )
}