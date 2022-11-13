package com.stas.clean.domain.usecase

import com.stas.clean.domain.models.SaveUserNameParam
import com.stas.clean.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(firstName: SaveUserNameParam): String {
        val oldUserName = userRepository.getName()

        if(oldUserName.firstname == firstName.name){
            return firstName.name
        }
        return userRepository.saveName(firstName = firstName).toString()
    }
}