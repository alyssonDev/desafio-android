package com.picpay.desafio.android.di

import com.picpay.desafio.android.domain.usercase.GetUser
import com.picpay.desafio.android.domain.usercase.GetUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetUserUseCase> { GetUser(get(), get()) }
}