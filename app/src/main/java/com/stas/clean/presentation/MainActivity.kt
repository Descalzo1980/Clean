package com.stas.clean.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.stas.clean.data.repository.UserRepositoryImpl
import com.stas.clean.databinding.ActivityMainBinding
import com.stas.clean.domain.models.SaveUserNameParam
import com.stas.clean.domain.models.UserName
import com.stas.clean.domain.usecase.GetUserNameUseCase
import com.stas.clean.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(context = applicationContext)}
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository)}
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {SaveUserNameUseCase(userRepository = userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(firstName = params)
            binding.dataTextView.text = result
        }

        binding.receiveButton.setOnClickListener {
            val userName : UserName = getUserNameUseCase.execute()
            binding.dataTextView.text = userName.firstname
        }

        binding.deleteButton.setOnClickListener {
            binding.dataTextView.text = " "
        }
    }
}