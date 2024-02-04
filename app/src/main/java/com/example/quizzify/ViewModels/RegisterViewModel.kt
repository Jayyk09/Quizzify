package com.example.quizzify.ViewModels
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    fun registerUser(name: String, email: String, password: String) {
        // Register the user

    }

    //validate the user input
    fun validateUserInput(name: String, email: String, password: String): Boolean {
        return name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()
    }
}