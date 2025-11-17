package com.kushy.arcadia.service

import com.kushy.arcadia.dto.WishlistDTO
import com.kushy.arcadia.entity.Game
import com.kushy.arcadia.entity.User
import com.kushy.arcadia.entity.Wishlist
import com.kushy.arcadia.repository.GameRepository
import com.kushy.arcadia.repository.UserRepository
import com.kushy.arcadia.repository.WishlistRepository
import org.springframework.stereotype.Service

@Service
class WishlistService(
    private val wishlistRepository: WishlistRepository,
    private val userRepository: UserRepository,
    private val gameRepository: GameRepository
) {

    fun addToWishlist(dto: WishlistDTO): Wishlist {

        val user: User = userRepository.findById(dto.userId)
            .orElseThrow { RuntimeException("Usuário não encontrado") }

        val game: Game = gameRepository.findById(dto.gameId)
            .orElseThrow { RuntimeException("Jogo não encontrado") }

        // Evita duplicação manualmente (e também pelo UniqueConstraint)
        if (wishlistRepository.existsByUserIdAndGameId(dto.userId, dto.gameId)) {
            throw IllegalArgumentException("Este jogo já está na wishlist do usuário.")
        }

        val wishlist = Wishlist(
            user = user,
            game = game
        )

        return wishlistRepository.save(wishlist)
    }

    fun removeFromWishlist(id: Long) {
        if (!wishlistRepository.existsById(id)) {
            throw RuntimeException("Item da wishlist não encontrado.")
        }
        wishlistRepository.deleteById(id)
    }

    fun getWishlistByUser(userId: Long): List<Wishlist> =
        wishlistRepository.findByUserId(userId)

    fun getRandomWishlistItem(userId: Long): Wishlist {
        val items = wishlistRepository.findByUserId(userId)

        if (items.isEmpty()) {
            throw RuntimeException("A wishlist do usuário está vazia.")
        }

        return items.random()
    }
}
