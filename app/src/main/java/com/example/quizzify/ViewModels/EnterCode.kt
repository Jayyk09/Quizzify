package com.example.quizzify.ViewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//viewmodel
sealed class EnterCodeViewState {
    object Loading : EnterCodeViewState()
    object Success : EnterCodeViewState()
    data class Error(val message: String) : EnterCodeViewState()
}
class EnterCode() : ViewModel() {
    // Enter code
    private val _enterCodeViewState = MutableLiveData<EnterCodeViewState>()
    val enterCodeState: LiveData<EnterCodeViewState> get() = _enterCodeViewState

    fun enterCode(code: String) {
        viewModelScope.launch {
            _enterCodeViewState.value = EnterCodeViewState.Loading
        }
        try {
            // Enter code
            _enterCodeViewState.value = EnterCodeViewState.Success
        } catch (e: Exception) {
            _enterCodeViewState.value = EnterCodeViewState.Error(e.message ?: "An unknown error occurred")
        }
    }
}