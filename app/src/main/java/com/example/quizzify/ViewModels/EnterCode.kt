package com.example.quizzify.ViewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizzify.api.Question
import com.example.quizzify.api.apiInterface
import kotlinx.coroutines.launch
import retrofit2.Response

//viewmodel
sealed class EnterCodeViewState {
    object Loading : EnterCodeViewState()
    data class Success(val data: List<Question>) : EnterCodeViewState()
    data class Error(val message: String) : EnterCodeViewState()
}
class EnterCode( private val myAPI: apiInterface) : ViewModel() {
    // Enter code
    private val _enterCodeViewState = MutableLiveData<EnterCodeViewState>()
    val enterCodeState: LiveData<EnterCodeViewState> get() = _enterCodeViewState

    class EnterCodeViewModel(private val myAPI: apiInterface) : ViewModel() {

        private val _enterCodeViewState = MutableLiveData<EnterCodeViewState>()
        val enterCodeState: LiveData<EnterCodeViewState> get() = _enterCodeViewState

        fun enterCode(code: String) {
            viewModelScope.launch {
                _enterCodeViewState.value = EnterCodeViewState.Loading

                try {
                    // Make the API call
                    val res: Response<List<Question>> = myAPI.Questions(code)

                    if (res.isSuccessful) {
                        val responseData = res.body()
                        if (responseData != null) {
                            _enterCodeViewState.value = EnterCodeViewState.Success(responseData)
                        } else {
                            _enterCodeViewState.value = EnterCodeViewState.Error("Empty response body")
                        }
                    } else {
                        _enterCodeViewState.value = EnterCodeViewState.Error("API Error: ${res.message()}")
                    }
                } catch (e: Exception) {
                    _enterCodeViewState.value = EnterCodeViewState.Error(e.message ?: "An unknown error occurred")
                }
            }
        }
    }
}