import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Produto from './componentes/Produto'
import CartaoPessoa from './componentes/CartaoPessoa'

function App() {
  return (
    <div>

      <h1> ATT 01</h1>
    <div className='containerCartao'>
    <Produto nome ="Arroz" preco = "10,00" />
    <Produto nome="Feijão" preco = "10,00" />

    <CartaoPessoa nome="Maria" idade="22" profissao="Designer" />
    </div>

    </div>
  )
}

export default App
