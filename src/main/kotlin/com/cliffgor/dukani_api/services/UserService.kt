package com.cliffgor.dukani_api.services

import com.cliffgor.dukani_api.models.User
import com.cliffgor.dukani_api.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun save(user:User): User {
        return this.userRepository.save(user)
    }
}