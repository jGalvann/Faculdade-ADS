package com.kushy.arcadia.repository

import com.kushy.arcadia.entity.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface GameRepository : JpaRepository<Game, Long> {

    // busca os jogos pelo nome
    fun findByNomeContainingIgnoreCase(nome: String): List<Game>

}