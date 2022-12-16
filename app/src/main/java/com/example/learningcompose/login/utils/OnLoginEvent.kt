package com.example.learningcompose.login.utils


sealed class OnLoginEvent{
    data class OnEmailChanged(val email: String): OnLoginEvent()
    data class OnPasswordChanged(val password: String): OnLoginEvent()
    data class OnConfirmPasswordChanged(val confirmPassword: String): OnLoginEvent()
    data class OnTermsAccepted(val isAccepted: Boolean): OnLoginEvent()
    object OnLoginButtonClicked: OnLoginEvent()
}
