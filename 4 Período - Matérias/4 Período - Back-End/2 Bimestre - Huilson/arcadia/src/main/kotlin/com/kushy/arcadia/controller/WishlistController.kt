package com.kushy.arcadia.controller

import com.kushy.arcadia.dto.WishlistDTO
import com.kushy.arcadia.entity.Wishlist
import com.kushy.arcadia.service.wishlist.WishlistService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/wishlist")

// Libera o acesso via CORS para qualquer origem (frontend)
@CrossOrigin(origins = ["*"])
class WishlistController(
    private val wishlistService: WishlistService
) {

    @PostMapping
    fun addToWishlist(@RequestBody dto: WishlistDTO): Wishlist =
        wishlistService.addToWishlist(dto)

    @GetMapping("/user/{userId}")
    fun getUserWishlist(@PathVariable userId: Long): List<Wishlist> =
        wishlistService.getWishlistByUser(userId)

    @GetMapping("/user/{userId}/random")
    fun getRandomItem(@PathVariable userId: Long): Wishlist =
        wishlistService.getRandomWishlistItem(userId)

    @DeleteMapping("/{id}")
    fun removeItem(@PathVariable id: Long) =
        wishlistService.removeFromWishlist(id)
}
