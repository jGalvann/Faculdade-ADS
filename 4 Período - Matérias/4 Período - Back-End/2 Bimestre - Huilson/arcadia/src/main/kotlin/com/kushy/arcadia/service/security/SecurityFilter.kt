package com.kushy.arcadia.service.security

import com.kushy.arcadia.repository.UserRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

/*
    Basicamente o SecurityFilter é o porteiro de um role, onde vai verificar se as pessoas tem o ingresso, e para qual área é o mesmo,
    ou seja, é aqui que o Token vai ser validado, e onde as permissões de casa usuário vao ser dadas.
    Normalmente as permissões são listas, então o mais básico seria a role de user, um usuário admin, vai ter em sua lista algo como ( role_user, role_admin), ou seja
    ele vai ter todas as permissões que um usuário comum tem, e as permissões de admin.

 */
@Component
class SecurityFilter(

    private val tokenService: TokenService,
    private val userRepository: UserRepository // Still needed to fetch the user by email

) : OncePerRequestFilter() { // filtro que é executado UMA VEZ por request ( assim que funfa o stateless )


    override fun doFilterInternal(

        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain

    ) {
        val tokenJWT = recoverToken(request)

        if (tokenJWT != null) {
            // 1. Validate the token and extract the login (email)
            val subject = tokenService.validateToken(tokenJWT)

            if (subject != null) {
                // 2. Fetch the user details using the email (subject)
                // O usuário retornado agora é um UserDetails válido.
                val usuario = userRepository.findByEmail(subject)

                if (usuario != null) {
                    // 3. Create the authentication object and set it in the Security Context.
                    // O método getAuthorities() AGORA existe na nossa entidade User (Passo 1).
                    val authentication = UsernamePasswordAuthenticationToken(usuario, null, usuario.authorities)

                    SecurityContextHolder.getContext().authentication = authentication
                }
            }
        }

        // 4. Continues the request flow to the next filter or to the Controller.
        filterChain.doFilter(request, response)
    }


    private fun recoverToken(request: HttpServletRequest): String? {  // recebe o request que veio do user
        val authorizationHeader = request.getHeader("Authorization")  // pega o header authorization, que no nosso caso, é onde está o token
        return authorizationHeader?.replace("Bearer ", "")
    }
}