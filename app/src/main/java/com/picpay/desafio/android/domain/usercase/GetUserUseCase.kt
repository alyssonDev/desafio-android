package com.picpay.desafio.android.domain.usercase

import com.picpay.desafio.android.data.remote.response.UserResponse
import com.picpay.desafio.android.domain.mapper.user.UserResponseToModelMapper
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.repository.UserRepository
import com.picpay.desafio.android.util.ResultOf

interface GetUserUseCase {
    suspend fun invoke(): ResultOf<List<User>>
}

class GetUser(
    private val mapper: UserResponseToModelMapper,
    private val userRepository: UserRepository
) : GetUserUseCase {
    override suspend fun invoke(): ResultOf<List<User>> {
        val result = userRepository.getUser()
        return when (result) {
            is ResultOf.Success -> {
                transformSuccess(result.value)
            }
            is ResultOf.Error -> transformError(result.message)
        }
    }

    private fun insertDataLocal(value: List<UserResponse>) {
        TODO("Not yet implemented")
    }

    private fun transformError(message: String?): ResultOf<List<User>> {
        return ResultOf.Error(message)
    }

    private fun transformSuccess(value: List<UserResponse>): ResultOf<List<User>> {
        return ResultOf.Success(toMapper(value))
    }

    private fun toMapper(value: List<UserResponse>): List<User> {
        val list = mutableListOf<User>()
        value.forEach {
            list.add(mapper.mapFrom(it))
        }
        return list
    }
}