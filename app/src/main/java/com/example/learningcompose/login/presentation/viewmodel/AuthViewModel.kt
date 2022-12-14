package com.example.learningcompose.login.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningcompose.login.data.AuthRepositoryImpl
import com.example.learningcompose.login.utils.LoginState
import com.example.learningcompose.login.utils.OnLoginEvent
import com.example.learningcompose.login.utils.ResultWrapper
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class AuthViewModel (
    private val authRepository: AuthRepositoryImpl = AuthRepositoryImpl()
): ViewModel() {

    var state by mutableStateOf(LoginState())
    private val loginEventChannel = Channel<OnLoginEvent>()
    val loginEvents = loginEventChannel.receiveAsFlow()

    fun onLoginEvent(event: OnLoginEvent){
       when(event){
           is OnLoginEvent.OnEmailChanged -> {
               state = state.copy(
                   email = event.email
               )
           }
           is OnLoginEvent.OnPasswordChanged -> {
               state = state.copy(
                   password = event.password
               )
           }
           is OnLoginEvent.OnConfirmPasswordChanged -> {
               state = state.copy(
                   confirmPassword = event.confirmPassword
               )
           }
           is OnLoginEvent.OnTermsAccepted -> {
               state = state.copy(
                   acceptedTerms = event.isAccepted
               )
           }
           is OnLoginEvent.OnLoginButtonClicked -> {
               submitLoginForm()
           }
           else -> Unit
       }
    }

    private fun submitLoginForm() {
        val email = authRepository.validateEmail(state.email)
        val password = authRepository.validatePassword(state.password)
        val confirmPassword = authRepository.validateConfirmPassword(
            state.password,
            state.confirmPassword
        )
        val terms = authRepository.validateTerms(state.acceptedTerms)
        listOf(
            email,
            password,
            confirmPassword,
            terms
        ).any { !it.successful }.also {
            if (it) {
               state =  state.copy(
                   emailError = email.errorMessage,
                   passwordError = password.errorMessage,
                   confirmPasswordError = confirmPassword.errorMessage,
                   termsError = terms.errorMessage
               )
                return
            }
        }

        viewModelScope.launch {
            loginEventChannel.send(ResultWrapper.Success)
        }
    }

}