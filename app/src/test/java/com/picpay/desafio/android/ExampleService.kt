package com.picpay.desafio.android

import com.picpay.desafio.android.data.remote.api.PicPayApi
import com.picpay.desafio.android.data.remote.response.UserResponse

class ExampleService(
    private val api: PicPayApi
) {

    fun example(): List<UserResponse> {
        val users = api.getUsers().execute()

        return users.body() ?: emptyList()
    }
}