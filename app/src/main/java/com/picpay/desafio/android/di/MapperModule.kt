package com.picpay.desafio.android.di

import com.picpay.desafio.android.domain.mapper.user.AppUserResponseToModelMapper
import com.picpay.desafio.android.domain.mapper.user.UserResponseToModelMapper
import com.picpay.desafio.android.domain.mapper.user.AppUserEntityToModelMapper
import com.picpay.desafio.android.domain.mapper.user.AppUserModelToEntityMapper
import com.picpay.desafio.android.domain.mapper.user.UserEntityToModelMapper
import com.picpay.desafio.android.domain.mapper.user.UserModelToEntityMapper
import org.koin.dsl.module

val mapperModule = module {
    factory<UserResponseToModelMapper> { AppUserResponseToModelMapper() }
    factory<UserEntityToModelMapper> { AppUserEntityToModelMapper() }
    factory<UserModelToEntityMapper> { AppUserModelToEntityMapper() }
}