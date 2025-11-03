package com.kushy.arcadia.entity

import jakarta.persistence.*

// @Entity: Marca a classe para ser persistida no banco.
@Entity
@Table(name = "games")
class Game(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    // idApi: O ID externo da RAWG
    @Column(unique = true) // faz com que o mesmo jogo não seja salvo 2x
    var idApi: String = "",

    var nome: String = "",
    var genero: String = "",
    var ano: Int? = null,
    var preco: String = "",
    var urlCover: String = "",

    @Lob // significa large object, ou seja, textão da descrição.
    var descricao: String = ""
) {
    // Construtor secundário vazio para auxiliar o JPA a criar a entidade
    constructor() : this(null, "", "", "", null, "", "", "")
}