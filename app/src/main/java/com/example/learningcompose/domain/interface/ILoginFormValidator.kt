package com.example.learningcompose.domain.`interface`

import com.example.learningcompose.domain.model.ValidationResultWrapper


interface ILoginValidator {

    fun validateEmail(userEmail: String): ValidationResultWrapper

    fun validatePassword(password: String): ValidationResultWrapper

    fun validateConfirmPassword(
        password: String,
        confirmPassword:String
    ): ValidationResultWrapper

    fun validateTerms(isAccepted: Boolean): ValidationResultWrapper
}