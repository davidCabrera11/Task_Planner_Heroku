package org.adaschool.TaskPlanner.controller.auth

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.adaschool.TaskPlanner.data.User
import org.adaschool.TaskPlanner.data.dto.LoginDto
import org.adaschool.TaskPlanner.data.dto.TokenDto
import org.adaschool.TaskPlanner.services.UserService
import org.adaschool.TaskPlanner.utils.CLAIMS_ROLES_KEY
import org.adaschool.TaskPlanner.utils.RoleEnum
import org.adaschool.TaskPlanner.utils.TOKEN_DURATION_MINUTES
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/auth")
class AuthController(
    @Value("\${SECRET}") val secret: String,
    @Autowired val userService: UserService
) {

    @PostMapping
    fun authenticate(@RequestBody loginDto: LoginDto) : TokenDto  {

        //TODO remove hard codded code and replace with comments
        val expirationDate = Calendar.getInstance()
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES)
        val token = generateAppToken("1213213", expirationDate.time)
        return TokenDto(token, expirationDate.time)

     /*   val user = userService.findByEmail(loginDto.email) ?: throw UserNotFoundException()

        if (BCrypt.checkpw(loginDto.password, user.passwordHash)){

            return generateTokenDto(user)

        }else
            throw InvalidCredentialsException()*/


    }



    private fun generateToken(user: User, expirationDate: Date): String {
        return Jwts.builder()
            .setSubject(user.id)
            .claim(CLAIMS_ROLES_KEY, user.roles)
            .setIssuedAt(Date())
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact()
    }

    private fun generateAppToken(userId: String, expirationDate: Date): String {
        return Jwts.builder()
            .setSubject(userId)
            .claim(CLAIMS_ROLES_KEY, listOf(RoleEnum.ADMIN))
            .setIssuedAt(Date())
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact()
    }









}