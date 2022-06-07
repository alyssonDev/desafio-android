package com.picpay.desafio.android.domain.mapper.user

import com.picpay.desafio.android.data.local.entity.UserEntity
import com.picpay.desafio.android.domain.mapper.Mapper
import com.picpay.desafio.android.domain.model.User

interface UserModelToEntityMapper: Mapper<User, UserEntity>

class AppUserModelToEntityMapper: UserModelToEntityMapper {
    override fun mapFrom(from: User): UserEntity {
        TODO("Not yet implemented")
    }
}