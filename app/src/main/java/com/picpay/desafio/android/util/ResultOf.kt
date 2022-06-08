package com.picpay.desafio.android.util


sealed class ResultOf<out T> {
    data class Success<out R>(val value: R) : ResultOf<R>()
    data class Error(val error: Throwable) : ResultOf<Nothing>()
}

