package com.kushy.arcadia.repository

import com.kushy.arcadia.entity.Wishlist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WishlistRepository : JpaRepository<Wishlist, Long> {

    // busca os itens da wishlist de um usuário especifico
    fun findAllByUserId(userId: Long): List<Wishlist>

    // Um métod para checar se o jogo já está na Wishlist ( evitar duplicatas )
    fun findByUserIdAndGameId(userId: Long, gameId: Long): Wishlist?
}