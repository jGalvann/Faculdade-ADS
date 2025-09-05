import { useState } from "react"
import Like from './Likes'
import ControleNota from './ControleNota'
import Votacao from './Votacao'
import Carrinho from './Carrinho'
import ConversorTemperatura from './ConversorTemperatura'
import Progresso from './Progresso'


/*
 anotação .filter -> 
 é basicamente a msm coisa que fzr um for e verificar item por item do array para remover algum. 
 a sintaxe é a seguinte -> .filter(nomeLocal => nomeLocal condição)
 aqui no meu caso eu usei (lista => lista !== atividade), quer dizer que, ele remove a att que entrou como parametro da lista
 ou seja, quer dizer que a checkbox estava selecionada e o user clicou novamente nela. 
*/
function Checkbox () {

    const [atividadesSelecionadas, setAtividadesSelecionadas] = useState([]) // como quero fazer com checkbox aqui tem que ser um array

    function mudarBloco(atividade){
        if (atividadesSelecionadas.includes(atividade)){
            const attNova = atividadesSelecionadas.filter(lista => lista !== atividade)
            setAtividadesSelecionadas(attNova)
        } else {
            const attNova = atividadesSelecionadas.concat(atividade)
            setAtividadesSelecionadas(attNova)
        }

    }

    return (
        <>
            <div className="gradeCima">
                <p>
                    LIKE
                <input 
                    type="checkbox" // tipo -> caixa
                    checked={atividadesSelecionadas.includes("Like")}  // aqui define se a checkbox vai aparecer marcada, se tem na lista, ent aparece
                    onChange={() => mudarBloco("Like")} // sendo bem sincero, bati cabeça e só funciona qndo tem esse () => 
                        // eu descobri o que é e como funfa, mas n queria usar. 
                />
                </p>
                 <p>
                    Controle Notas
                <input 
                    type="checkbox"
                    checked={atividadesSelecionadas.includes("ControleNota")}
                    onChange={() => mudarBloco("ControleNota")}
                />
                </p>
                 <p>
                    Votação
                <input 
                    type="checkbox"
                    checked={atividadesSelecionadas.includes("Votacao")}
                    onChange={() => mudarBloco("Votacao")}
                />
                </p>
                 <p>
                    Carrinho
                <input 
                    type="checkbox"
                    checked={atividadesSelecionadas.includes("Carrinho")}
                    onChange={() => mudarBloco("Carrinho")}
                />
                </p>
                 <p>
                    Conversor Temperatura
                <input 
                    type="checkbox"
                    checked={atividadesSelecionadas.includes("ConversorTemperatura")}
                    onChange={() => mudarBloco("ConversorTemperatura")}
                />
                </p>
                 <p>
                    Progresso
                <input 
                    type="checkbox"
                    checked={atividadesSelecionadas.includes("Progresso")}
                    onChange={() => mudarBloco("Progresso")}
                />
                </p>

        
            </div>
            <div>
                <div className="grade">
                    {atividadesSelecionadas.includes("Like") && <Like />/*  aqui checa se o item esta marcado e renderiza ele} */}
                    {atividadesSelecionadas.includes("ControleNota") && <ControleNota />}
                    {atividadesSelecionadas.includes("Votacao") && <Votacao />}
                    {atividadesSelecionadas.includes("Carrinho") && <Carrinho />}
                    {atividadesSelecionadas.includes("ConversorTemperatura") && <ConversorTemperatura />}
                    {atividadesSelecionadas.includes("Progresso") && <Progresso />}
                </div>
            </div>
        </>
    )

}
export default Checkbox