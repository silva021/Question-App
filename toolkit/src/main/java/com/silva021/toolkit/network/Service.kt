package com.silva021.toolkit.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://question-app-021.herokuapp.com/"

class Service {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun <API> createService(serviceClass: Class<API>): API {
        return retrofit.create(serviceClass)
    }
}