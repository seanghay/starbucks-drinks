package com.seanghay.starbucksdrinks.http

import com.seanghay.starbucksdrinks.data.MenuResponse
import retrofit2.http.GET

interface MenuService {

    @GET("bff/ordering/menu")
    suspend fun menu(): MenuResponse
}