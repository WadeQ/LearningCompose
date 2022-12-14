package com.example.learningcompose.login.utils

data class LoginState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val confirmPassword: String = "",
    val confirmPasswordError: String? = null,
    val acceptedTerms: Boolean = false,
    val termsError: String? = null ,
)
