package com.stas.clean.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import com.stas.clean.databinding.ActivityMainBinding
import com.stas.clean.domain.models.SaveUserNameParam
import com.stas.clean.domain.models.UserName
import com.stas.clean.domain.usecase.DeleteUserNameUseCase
import com.stas.clean.domain.usecase.GetUserNameUseCase
import com.stas.clean.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result : String = saveUserNameUseCase.execute(param = params)
            binding.dataTextView.text = "$result"
        }

        binding.receiveButton.setOnClickListener {
            val userName : UserName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstname}"
        }

        binding.deleteButton.setOnClickListener {
            binding.dataTextView.text = " "
        }
    }
}