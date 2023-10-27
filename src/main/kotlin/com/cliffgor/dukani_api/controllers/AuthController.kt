package com.cliffgor.dukani_api.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthController {
    @GetMapping("register")
    fun register(): String {
        return "register your credentials"
    }
}