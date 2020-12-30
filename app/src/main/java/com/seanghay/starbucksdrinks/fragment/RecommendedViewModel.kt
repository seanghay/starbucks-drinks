package com.seanghay.starbucksdrinks.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.seanghay.resultof.resultOf
import com.seanghay.starbucksdrinks.StarbucksApp
import com.seanghay.starbucksdrinks.data.ProductCategory
import com.seanghay.starbucksdrinks.data.ProductItem
import kotlinx.coroutines.Dispatchers

class RecommendedViewModel : ViewModel() {

    val featuredProducts = liveData(Dispatchers.IO) {
        emit(resultOf {
            val products = StarbucksApp.menuRepository.fetchOrCache().flatMap { flatten(it) }
            products.shuffled().take(20)
        })
    }


    val popularDrinks = liveData(Dispatchers.IO) {
        emit(resultOf {
            val products = StarbucksApp.menuRepository.fetchOrCache().flatMap { flatten(it) }
            products.shuffled().take(4)
        })
    }

    val signatureDrinks = liveData(Dispatchers.IO) {
        emit(resultOf {
            val products = StarbucksApp.menuRepository.fetchOrCache().flatMap { flatten(it) }
            products.shuffled().take(5)
        })
    }

    val allProducts = liveData(Dispatchers.IO) {
        emit(resultOf { StarbucksApp.menuRepository.fetchOrCache().flatMap { flatten(it) } })
    }


    private fun flatten(item: ProductCategory): List<ProductItem> {

        if (item.products != null && item.products.isNotEmpty()) {
            return item.products
        }

        if (item.children != null && item.children.isNotEmpty()) {
            return item.children.flatMap { x -> flatten(x) }
        }

        return emptyList()
    }
}