package com.picpay.desafio.android.data.remote.api

import com.picpay.desafio.android.data.remote.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET


interface PicPayApi {

    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}