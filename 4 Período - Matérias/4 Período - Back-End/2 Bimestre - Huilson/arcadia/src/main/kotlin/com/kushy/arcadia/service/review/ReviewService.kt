package com.kushy.arcadia.service.review

import com.kushy.arcadia.dto.ReviewCreateDTO
import com.kushy.arcadia.dto.ReviewResponseDTO
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

    fun createReview(dto: ReviewCreateDTO, currentUser: User): ReviewResponseDTO {
        // validação nota
        if (dto.nota < 0.5f || dto.nota > 5f)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Nota deve estar entre 0.5 e 5.0")

        // usuário autenticado
        val authUser: User = securityUtils.getAuthenticatedUser()

        // garantir que o user não esteja criando review em nome de outro user
        if (!securityUtils.isAdmin() && dto.userId != authUser.id)
            throw ResponseStatusException(HttpStatus.FORBIDDEN, "Você só pode criar reviews para o seu próprio usuário")

        val user = userRepository.findById(dto.userId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado") }

        val game = gameRepository.findById(dto.gameId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado") }

        if (reviewRepository.existsByUserIdAndGameId(dto.userId, dto.gameId)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "O usuário já fez review desse jogo.")
        }

        val review = Review(
            user = user,        // ver se tem problema deixar o authUser aqui, que dai economiza uma pesquisa no banco
            game = game,
            nota = dto.nota,
            textReview = dto.textReview,
            status = dto.status
        )

        return reviewRepository.save(review).toDTO()
    }


    fun updateReview(id: Long, dto: ReviewUpdateDTO, currentUser: User): ReviewResponseDTO {              // Aqui ele está recebendo o ID do @PathVariable
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


        var nota: Float = 0.0f
        if (review.nota!! < 0.5f || review.nota!! > 5f)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Nota deve estar entre 0.5 e 5.0")

        return reviewRepository.save(review).toDTO()
    }

    fun deleteReview(id: Long, currentUser: User) {
        val review = reviewRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Review não encontrada") }

        val authUser = securityUtils.getAuthenticatedUser()

        val isOwner = review.user.id == authUser.id
        val isAdmin = securityUtils.isAdmin()

        if (!isOwner && !isAdmin) {                 // checa se o usuário é o owner da review ou se é admin.
            throw ResponseStatusException(
                HttpStatus.FORBIDDEN,
                "Você não tem permissão para excluir esta review."
            )
        }


        reviewRepository.deleteById(id)
    }


    fun Review.toDTO() = ReviewResponseDTO(
        id = this.id!!,
        userId = this.user.id!!,
        gameId = this.game.id!!,
        nota = this.nota,
        textReview = this.textReview,
        status = this.status
    )


    fun getReviewById(id: Long): ReviewResponseDTO {
        val review = reviewRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Review não encontrada") }

        return review.toDTO()
    }


    fun getReviewsByUser(userId: Long): List<ReviewResponseDTO> {
        return reviewRepository.findByUserId(userId)
            .map { it.toDTO() }
    }


    fun getReviewsByGame(gameId: Long): List<ReviewResponseDTO> {
        return reviewRepository.findByGameId(gameId)
            .map { it.toDTO() }
    }
}
