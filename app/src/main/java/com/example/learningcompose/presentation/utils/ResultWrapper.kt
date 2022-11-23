package com.example.learningcompose.presentation.utils

import com.example.learningcompose.domain.model.ValidationResultWrapper


sealed class ResultWrapper{
    object Success: OnLoginEvent()
}
