package com.kushy.arcadia.controller

import com.kushy.arcadia.dto.ReviewCreateDTO
import com.kushy.arcadia.dto.ReviewUpdateDTO
import com.kushy.arcadia.entity.Review
import com.kushy.arcadia.service.ReviewService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = ["*"])
class ReviewController(
    private val reviewService: ReviewService
) {

    @PostMapping
    fun create(@RequestBody dto: ReviewCreateDTO): Review =
        // Chama o service para criar a review e retorna o objeto criado
        reviewService.createReview(dto)

    // {id} é extraído da URL através de @PathVariable
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Review =
        reviewService.getReviewById(id)

    @GetMapping("/user/{userId}")
    fun getByUser(@PathVariable userId: Long): List<Review> =
        reviewService.getReviewsByUser(userId)

    @GetMapping("/game/{gameId}")
    fun getByGame(@PathVariable gameId: Long): List<Review> =
        reviewService.getReviewsByGame(gameId)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody dto: ReviewUpdateDTO
    ): Review = reviewService.updateReview(id, dto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        reviewService.deleteReview(id)
}
