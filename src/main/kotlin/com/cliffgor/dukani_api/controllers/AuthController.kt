package com.cliffgor.dukani_api.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthController {
    @GetMapping("hello")
    fun hello(): String {
        return "hello"
    }
}