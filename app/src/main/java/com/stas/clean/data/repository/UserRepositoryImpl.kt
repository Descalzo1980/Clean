package com.stas.clean.data.repository

import android.content.Context
import com.stas.clean.domain.models.SaveUserNameParam
import com.stas.clean.domain.models.UserName
import com.stas.clean.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val DEFAULT_NAME = "Alex"

class UserRepositoryImpl(context: Context) : UserRepository{

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE)

    override fun saveName(firstName: SaveUserNameParam): String {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, firstName.name).apply()
        return firstName.name
    }

    override fun getName(): UserName {

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME,"Alex") ?: DEFAULT_NAME

        return UserName(firstname = firstName)
    }

}