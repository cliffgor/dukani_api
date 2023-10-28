package com.cliffgor.dukani_api.controllers

import com.cliffgor.dukani_api.dtos.LoginDTO
import com.cliffgor.dukani_api.dtos.Message
import com.cliffgor.dukani_api.dtos.RegisterDTO
import com.cliffgor.dukani_api.models.User
import com.cliffgor.dukani_api.services.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("api")
class AuthController(private val userService: UserService) {
    @PostMapping("register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<User> {
        val user = User()
        user.name = body.name
        user.email = body.email
        user.password = body.password
        return ResponseEntity.ok(this.userService.save(user))
    }

    @PostMapping("login")
    fun login(@RequestBody body: LoginDTO): ResponseEntity<Any> {
        val user = this.userService.findByEmail(body.email)
            ?: return ResponseEntity.badRequest().body(Message("user hapatikani"))

        if(!user.comparePassword(body.password)) {
            return ResponseEntity.badRequest().body(Message("Ivalid Password"))
        }

        val issuer = user.id.toString()

        val secretKey = "secret"

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60*24*1000)) //Expiration set to 1 day
            .signWith(SignatureAlgorithm.HS256, secretKey).compact()

        return ResponseEntity.ok(jwt)
    }
}