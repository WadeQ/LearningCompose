package com.example.learningcompose.login.utils



data class ValidationResultWrapper(
    val successful : Boolean,
    val errorMessage: String? = null
)
