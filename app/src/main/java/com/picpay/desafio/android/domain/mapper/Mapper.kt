package com.picpay.desafio.android.domain.mapper

interface Mapper<in E, T> {
    fun mapFrom(from: E): T
}