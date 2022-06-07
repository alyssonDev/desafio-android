package com.picpay.desafio.android.domain.mapper.user

import com.picpay.desafio.android.data.local.entity.UserEntity
import com.picpay.desafio.android.domain.mapper.Mapper
import com.picpay.desafio.android.domain.model.User

interface UserEntityToModelMapper : Mapper<UserEntity, User>

class AppUserEntityToModelMapper : UserEntityToModelMapper {
    override fun mapFrom(from: UserEntity): User {
        TODO("Not yet implemented")
    }
}