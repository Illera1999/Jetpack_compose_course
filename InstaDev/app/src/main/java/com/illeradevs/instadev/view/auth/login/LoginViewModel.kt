package com.illeradevs.instadev.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChange(email: String) {
        _uiState.update { state ->
            state.copy(email = email)
        }
        verifyLogin()
    }

    fun onPasswordChange(password: String) {
        _uiState.update { state ->
            state.copy(password = password)
        }
        verifyLogin()
    }

    private fun verifyLogin() {
        val enabledLogin = isEmailValid(_uiState.value.email) && isPassword(_uiState.value.password)
        _uiState.update { state ->
            state.copy(isLoadingEnabled = enabledLogin)
        }
    }

    fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isPassword(password: String): Boolean = password.length > 6
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoadingEnabled: Boolean = false
)

//sealed class MyUIState{
//    object Error
//    data class Success(val test:String)
//}