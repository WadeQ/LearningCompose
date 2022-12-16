package com.example.learningcompose.login.utils


sealed class ResultWrapper{
    object Success: OnLoginEvent()
}
