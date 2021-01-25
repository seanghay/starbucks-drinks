package com.seanghay.starbucksdrinks.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.seanghay.starbucksdrinks.data.ProductCategory
import com.seanghay.starbucksdrinks.http.MenuService
import java.io.File
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MenuRepository(
    private val context: Context,
    private val service: MenuService
) {
    private val file = File(context.filesDir, FILE_NAME)

    private var memoryCache: List<ProductCategory>? = null

    suspend fun fetchOrCache(): List<ProductCategory> {
        memoryCache?.let {
            return it
        }

        val cached = loadFromFile()
        cached?.let {
            memoryCache = it
            return it
        }
        val remote = service.menu()
        remote.menus?.let {
            memoryCache = it
            storeFile(it)

            return it
        }
        return emptyList()
    }

    private suspend fun storeFile(data: List<ProductCategory>) = suspendCoroutine<Unit> {
        if (file.exists()) file.delete()
        it.resumeWith(runCatching {
            val text = gson.toJson(data)
            file.writeText(text)
        })
    }

    private suspend fun loadFromFile() = suspendCoroutine<List<ProductCategory>?> {
        if (!file.exists()) {
            it.resume(null)
        } else {
            val result = try {
                val rawJSON = file.readText()
                val typeToken = object : TypeToken<List<ProductCategory>>() {}.type
                gson.fromJson<List<ProductCategory>>(rawJSON, typeToken)
            } catch (e: Throwable) {
                null
            }
            it.resume(result)

        }
    }

    companion object {
        private const val FILE_NAME = "starbucks-menu.json"
        private val gson = Gson()
    }
}