package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.remote.api.PicPayApi
import com.picpay.desafio.android.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}