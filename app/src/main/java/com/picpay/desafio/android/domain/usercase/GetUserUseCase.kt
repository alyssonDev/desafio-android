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
        return when (val result = userRepository.getUser()) {
            is ResultOf.Success -> {
                transformSuccess(result.value)
            }
            is ResultOf.Error -> transformError(result.error)
        }
    }

    private fun transformError(error: Throwable): ResultOf<List<User>> {
        return ResultOf.Error(error)
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