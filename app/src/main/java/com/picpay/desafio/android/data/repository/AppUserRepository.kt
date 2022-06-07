package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.remote.api.PicPayApi
import com.picpay.desafio.android.data.remote.response.UserResponse
import com.picpay.desafio.android.domain.repository.UserRepository
import com.picpay.desafio.android.util.ResultOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class AppUserRepository(private val picPayApi: PicPayApi) : UserRepository {
    override suspend fun getUser(): ResultOf<List<UserResponse>> = withContext(Dispatchers.IO) {
        try {
            ResultOf.Success(picPayApi.getUsers())
        } catch (exception: Exception) {
            ResultOf.Error(exception.message)
        }
    }

}