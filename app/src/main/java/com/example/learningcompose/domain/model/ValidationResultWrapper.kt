package com.example.learningcompose.domain.model



data class ValidationResultWrapper(
    val successful : Boolean,
    val errorMessage: String? = null
)
