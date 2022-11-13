package com.stas.clean.domain.repository

import com.stas.clean.domain.models.SaveUserNameParam
import com.stas.clean.domain.models.UserName

interface UserRepository {

    fun saveName(firstName: SaveUserNameParam) : String

    fun getName(): UserName
}