package com.kushy.arcadia.service

import com.kushy.arcadia.dto.ReviewCreateDTO
import com.kushy.arcadia.dto.ReviewUpdateDTO
import com.kushy.arcadia.entity.Review
import com.kushy.arcadia.entity.User
import com.kushy.arcadia.repository.GameRepository
import com.kushy.arcadia.repository.ReviewRepository
import com.kushy.arcadia.repository.UserRepository
import com.kushy.arcadia.service.security.SecurityUtils
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val userRepository: UserRepository,
    private val gameRepository: GameRepository,
    private val securityUtils: SecurityUtils
) {

    fun createReview(dto: ReviewCreateDTO): Review {
        // validação nota
        if (dto.nota < 0.5f || dto.nota > 5f)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Nota deve estar entre 0.5 e 5.0")

        // usuário autenticado (quem faz a requisição)
        val authUser: User = securityUtils.getAuthenticatedUser()

        // garantir que o cliente não esteja criando review em nome de outro usuário
        if (dto.userId != authUser.id)
            throw ResponseStatusException(HttpStatus.FORBIDDEN, "Você só pode criar reviews em seu próprio usuário")

        val user = userRepository.findById(dto.userId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado") }

        val game = gameRepository.findById(dto.gameId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado") }

        if (reviewRepository.existsByUserIdAndGameId(dto.userId, dto.gameId)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "O usuário já fez review desse jogo.")
        }

        val review = Review(
            user = user,
            game = game,
            nota = dto.nota,
            textReview = dto.textReview,
            status = dto.status
        )

        return reviewRepository.save(review)
    }

    fun updateReview(id: Long, dto: ReviewUpdateDTO): Review {
        val review = reviewRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Review não encontrada") }

        val authUser = securityUtils.getAuthenticatedUser()

        // somente autor pode atualizar
        if (review.user.id != authUser.id)
            throw ResponseStatusException(HttpStatus.FORBIDDEN, "Você não tem permissão para alterar esta review")

        // atualização parcial
        review.nota = dto.nota ?: review.nota
        review.textReview = dto.textReview ?: review.textReview
        review.status = dto.status ?: review.status

        // revalidação simples (opcional) - valida nota atualizada
        if (review.nota < 0.5f || review.nota > 5f)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Nota deve estar entre 0.5 e 5.0")

        return reviewRepository.save(review)
    }

    fun deleteReview(id: Long) {
        val review = reviewRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Review não encontrada") }

        val authUser = securityUtils.getAuthenticatedUser()
        if (review.user.id != authUser.id)
            throw ResponseStatusException(HttpStatus.FORBIDDEN, "Você não tem permissão para deletar esta review")

        reviewRepository.deleteById(id)
    }

    fun getReviewById(id: Long): Review =
        reviewRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Review não encontrada") }

    fun getReviewsByUser(userId: Long): List<Review> =
        reviewRepository.findByUserId(userId)

    fun getReviewsByGame(gameId: Long): List<Review> =
        reviewRepository.findByGameId(gameId)
}
