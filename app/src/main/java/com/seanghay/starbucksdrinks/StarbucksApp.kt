package com.seanghay.starbucksdrinks

import android.app.Application
import android.content.Context
import com.seanghay.starbucksdrinks.http.menuService
import com.seanghay.starbucksdrinks.repository.MenuRepository

class StarbucksApp : Application() {

    override fun onCreate() {
        appContext = applicationContext
        super.onCreate()
        menuRepository = MenuRepository(this, menuService)
    }

    companion object {

        lateinit var menuRepository: MenuRepository
            private set

        @JvmStatic
        @Volatile
        lateinit var appContext: Context
            private set

    }
}