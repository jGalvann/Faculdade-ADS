package com.kushy.arcadia.dto

import java.time.Instant

data class ReviewResponseDTO(
    val id: Long,
    val userId: Long,
    val gameId: Long,
    val nota: Float,
    val textReview: String?,
    val status: String?
)
