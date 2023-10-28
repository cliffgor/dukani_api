package com.cliffgor.dukani_api.controllers

import com.cliffgor.dukani_api.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api")
class AuthController(private val userService: UserService) {
    @GetMapping("api/register")
    fun register(): String {
        return "register your credentials"
    }
}