import { useState } from 'react'
import './App.css'
import { FormularioItem } from './componentes/FormularioItem'
import { ListaItens } from './componentes/ListaItens'

function App() {
  const [listaItens, setListaItens] = useState([])

 

  return (
    <>
      <FormularioItem
        listaItens={listaItens}
        setListaItens={setListaItens}
      />
      <ListaItens
        itens={listaItens}
        setListaItens={setListaItens}
      />
    </>
  )
}

export default App
