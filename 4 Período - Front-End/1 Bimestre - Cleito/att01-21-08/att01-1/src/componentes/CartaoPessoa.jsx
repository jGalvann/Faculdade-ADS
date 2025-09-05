function CartaoPessoa(props) {
    return (
    <div className="cartao">
        <h2>{props.nome}</h2>
        <p>Idade: {props.idade}</p>
        <p>Profissão: {props.profissao}</p>
  </div>
    )
  }
  
  export default CartaoPessoa
  

