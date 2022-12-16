package com.example.learningcompose.login.domain.`interface`

import com.example.learningcompose.login.utils.ValidationResultWrapper


interface ILoginValidator {

    fun validateEmail(userEmail: String): ValidationResultWrapper

    fun validatePassword(password: String): ValidationResultWrapper

    fun validateConfirmPassword(
        password: String,
        confirmPassword:String
    ): ValidationResultWrapper

    fun validateTerms(isAccepted: Boolean): ValidationResultWrapper
}