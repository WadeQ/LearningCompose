package com.example.learningcompose.data

import android.util.Patterns
import com.example.learningcompose.domain.`interface`.ILoginValidator
import com.example.learningcompose.domain.model.ValidationResultWrapper


class AuthRepositoryImpl() : ILoginValidator{

    override fun validateEmail(userEmail: String): ValidationResultWrapper {
       if(userEmail.isBlank()){
           return ValidationResultWrapper(
               successful = false,
               errorMessage = "Email field cannot be blank!"
           )
       }
        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            return ValidationResultWrapper(
                successful = false,
                errorMessage = "The email is not valid"
            )
        }
        return ValidationResultWrapper(
            successful = true
        )
    }

    override fun validatePassword(password: String): ValidationResultWrapper {
        if(password.length < 8){
            return ValidationResultWrapper(
                successful = false,
                errorMessage = "Password needs to be more than 8 characters!"
            )
        }
        password.any { it.isDigit() }  && password.any { it.isLetter() }.also {
            if (!it){
                return ValidationResultWrapper(
                    successful = false,
                    errorMessage = "The password needs to have at least one digit and letter!"
                )
            }
        }

        return ValidationResultWrapper(
            successful = true
        )
    }

    override fun validateConfirmPassword(
        password: String,
        confirmPassword: String
    ): ValidationResultWrapper {
        if(password != confirmPassword){
            return ValidationResultWrapper(
                successful = false,
                errorMessage = "Passwords ddo not match!"
            )
        }

        return ValidationResultWrapper(
            successful = true
        )
    }

    override fun validateTerms(isAccepted: Boolean): ValidationResultWrapper {
        if (!isAccepted){
            return ValidationResultWrapper(
                successful = false,
                errorMessage = "You must first accept terms!"
            )
        }
        return ValidationResultWrapper(
            successful = true
        )
    }
}