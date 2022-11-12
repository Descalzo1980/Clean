package com.stas.clean.domain.usecase

import com.stas.clean.domain.models.DeleteUserName

class DeleteUserNameUseCase() {

    fun execute(param: DeleteUserName): String {
        return param.name
    }

}