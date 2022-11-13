package com.stas.clean.domain.usecase

import com.stas.clean.domain.models.UserName
import com.stas.clean.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute() : UserName{
        return userRepository.getName()
    }
}