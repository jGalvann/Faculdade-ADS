import React from 'react';
import QuadradoPreto from './QuadradoPreto';
import QuadradoVazio from './QuadradoVazio';
import '../estiloComponente/QuadradoBranco.css'
import '../estiloComponente/arrayQuadrado.css'


// optei por utilizar array ao invés de fzr na mão
function QuadradoBranco() {
  const quadrados = [];

  for (let i = 0; i < 64; i++) {
    if ((Math.floor(i / 8) + i) % 2 === 0) {
       quadrados.push(<QuadradoVazio key={i} />);
    } else {
      quadrados.push(<QuadradoPreto key={i} />);
}

  }

  return <div className="QuadradoBranco arrayQuadrado">{quadrados}</div>; // retorna esse array grandão
}

export default QuadradoBranco;
