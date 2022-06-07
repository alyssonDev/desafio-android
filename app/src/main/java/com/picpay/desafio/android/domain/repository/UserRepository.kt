package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.data.remote.response.UserResponse
import com.picpay.desafio.android.util.ResultOf

interface UserRepository {
    suspend fun getUser(): ResultOf<List<UserResponse>>
}