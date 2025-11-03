package com.kushy.arcadia.entity

import com.kushy.arcadia.entity.enums.Role
import jakarta.persistence.*

// O lombok funciona mto bem em java, mas nem tanto assim em kotlin, então nao precisa das anotações @Getter, @Setter @NoArgsConstructor e @AllArgsConstructor. O Kotlin faz isso automaticamente.


@Entity // marca a classe como uma entidade JPA, que vai ser mapeada para o banco de dados.
@Table(name = "users")  // especifica o nome da tabela no banco de dados.



class User(
    @Id // marca o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define a estratégia de geração do ID, a IDENTITY usa a parada de auto-incremento do postgres
    var id: Long? = null,

    var username: String = "",

    // O 'unique' garante que não haverá dois logins com o mesmo email.
    @Column(unique = true) // garante que o email seja único no banco.
    var email: String = "",

    // Senha criptografada.
    var password : String = "",

    // @Enumerated(EnumType.STRING) é a melhor prática para o JPA.
    @Enumerated(EnumType.STRING) // @Enumerated(EnumType.STRING): Salva o nome do Enum ("USER" ou "ADMIN") no banco.
    var role : Role = Role.USER // Role padrão definida ( usuário ).

    // OBS: optei por fzr os relacionamentos unilaterais para manter a simplicidade da aplicação.
) {
    // Construtor secundário vazio para o JPA.
    constructor() : this(null, "", "", "", Role.USER)
}

/*
    Para criar instâncias de entidades que foram recuperadas do banco de dados, o Hibernate precisa de um construtor sem argumentos, que seja no minimo protected ( ou public. )
    qndo o hibernate executa um query e recebe os dados de uma linha, ele não chama o construtor primário, em vez disso ele usa um mecanismo chamado reflexão para:
        criar uma nova instância da classe User chamando um construtor vazio.
        em seguida, usa os setters ou acessa direamente os campos para preencher os valores que vieram do banco.
 */