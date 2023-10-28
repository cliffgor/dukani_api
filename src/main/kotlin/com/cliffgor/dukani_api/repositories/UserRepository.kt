package com.cliffgor.dukani_api.repositories

import com.cliffgor.dukani_api.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
    fun findByEmail(email: String): User?
}