package com.stas.clean.domain.usecase

import com.stas.clean.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam) : String {
        return param.name
    }
}