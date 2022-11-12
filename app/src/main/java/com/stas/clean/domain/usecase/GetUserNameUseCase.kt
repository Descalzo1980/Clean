package com.stas.clean.domain.usecase

import com.stas.clean.domain.models.UserName

class GetUserNameUseCase {

    fun execute() : UserName{
        return UserName(firstname = "Stas", lastName = "Leonov")
    }
}