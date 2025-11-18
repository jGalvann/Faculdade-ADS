package com.kushy.arcadia.controller

import com.kushy.arcadia.dto.ReviewCreateDTO
import com.kushy.arcadia.dto.ReviewResponseDTO
import com.kushy.arcadia.dto.ReviewUpdateDTO
import com.kushy.arcadia.entity.User
import com.kushy.arcadia.service.review.ReviewService
import com.kushy.arcadia.service.security.SecurityUtils
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = ["*"])
class ReviewController(
    private val reviewService: ReviewService,
    private val securityUtils: SecurityUtils
) {

    @PostMapping
    fun create(@RequestBody dto: ReviewCreateDTO): ReviewResponseDTO {
        val user = securityUtils.getAuthenticatedUser()
        return reviewService.createReview(dto, user)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ReviewResponseDTO {
        return reviewService.getReviewById(id)
    }

    @GetMapping("/user/{userId}")
    fun getByUser(@PathVariable userId: Long): List<ReviewResponseDTO> {
        return reviewService.getReviewsByUser(userId)
    }

    @GetMapping("/game/{gameId}")
    fun getByGame(@PathVariable gameId: Long): List<ReviewResponseDTO> {
        return reviewService.getReviewsByGame(gameId)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody dto: ReviewUpdateDTO
    ): ReviewResponseDTO {
        val user = securityUtils.getAuthenticatedUser()
        return reviewService.updateReview(id, dto, user)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        val user = securityUtils.getAuthenticatedUser()
        reviewService.deleteReview(id, user)
    }
}

