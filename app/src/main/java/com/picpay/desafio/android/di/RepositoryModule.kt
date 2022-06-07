package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.repository.AppUserRepository
import com.picpay.desafio.android.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<UserRepository> { AppUserRepository(get()) }
}