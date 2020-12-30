package com.seanghay.starbucksdrinks.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private val httpClient = OkHttpClient.Builder().build()
private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.starbucks.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

internal val menuService: MenuService = retrofit.create()


