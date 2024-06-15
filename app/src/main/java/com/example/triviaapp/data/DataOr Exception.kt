package com.example.triviaapp.data

data class DataOrException<T, E: Exception, Boolean> (
    var data: T? = null,
    var e: E? = null,
    var loading: Boolean? = null
)