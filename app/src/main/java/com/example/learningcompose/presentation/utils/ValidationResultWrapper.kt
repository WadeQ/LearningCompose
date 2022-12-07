package com.example.learningcompose.presentation.utils



data class ValidationResultWrapper(
    val successful : Boolean,
    val errorMessage: String? = null
)
