package com.cliffgor.dukani_api.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api")
class AuthController {
    @GetMapping("api/register")
    fun register(): String {
        return "register your credentials"
    }
}