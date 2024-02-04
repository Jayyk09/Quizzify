package com.example.quizzify.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizzify.api.LoginRequest
import com.example.quizzify.api.LoginResponse
import com.example.quizzify.api.apiInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val apiService: apiInterface) : ViewModel() {
    private val _loginResult = MutableStateFlow<LoginResult?>(null)
    val loginResult: StateFlow<LoginResult?> = _loginResult

    // Keep track of token from the api
    var token: String? = null

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response: Response<LoginResponse> = apiService.loginUser(
                    request = LoginRequest(
                        email = email,
                        password = password
                    )
                )

                if (response.isSuccessful) {
                    // Successful login, handle the response accordingly
                    val loginResponse = response.body()
                    // Access the token or perform other actions based on the response
                    token = loginResponse?.token
                    _loginResult.value = LoginResult.Success
                } else {
                    // Unsuccessful login, handle the error response
                    _loginResult.value = LoginResult.Error("Login failed: ${response.message()}")
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
                _loginResult.value = LoginResult.Error("An unexpected error occurred")
            }
        }
    }

    sealed class LoginResult {
        object Success : LoginResult()
        data class Error(val message: String) : LoginResult()
    }
}
