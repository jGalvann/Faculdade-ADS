package com.kushy.arcadia.repository

import com.kushy.arcadia.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long> {

    // busca as reviews feitas por um user específico.
    fun findAllByUserId(userId: Long): List<Review>

}