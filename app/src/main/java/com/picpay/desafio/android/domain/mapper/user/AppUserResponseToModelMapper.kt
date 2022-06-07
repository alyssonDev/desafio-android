package com.picpay.desafio.android.domain.mapper.user

import com.picpay.desafio.android.data.remote.response.UserResponse
import com.picpay.desafio.android.domain.mapper.Mapper
import com.picpay.desafio.android.domain.model.User

interface UserResponseToModelMapper : Mapper<UserResponse, User>

class AppUserResponseToModelMapper : UserResponseToModelMapper {

    override fun mapFrom(from: UserResponse) = User(
        img = from.img,
        name = from.name,
        id = from.id,
        username = from.username
    )
}