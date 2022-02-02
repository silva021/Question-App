package com.silva021.toolkit.network.response

sealed class Result<out S, out E> {
    data class Success<S>(val data : S) : Result<S, Nothing>()
    data class Failure<E>(val exception : E) : Result<Nothing, E>()
}