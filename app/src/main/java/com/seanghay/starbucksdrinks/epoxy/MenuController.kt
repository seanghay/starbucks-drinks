package com.seanghay.starbucksdrinks.epoxy

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import com.seanghay.resultof.ResultOf
import com.seanghay.resultof.onFailure
import com.seanghay.resultof.onSuccess
import com.seanghay.starbucksdrinks.data.MenuResponse
import com.seanghay.starbucksdrinks.data.ProductCategory

class MenuController : EpoxyController(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {

    private var _currentResult: ResultOf<List<ProductCategory>>? = null

    override fun buildModels() {
        val result = _currentResult

        if (result == null) {
            loaderModelView { id("loader") }
            return
        }

        result.onFailure {
            failureModelView {
                id("failure")
            }
        }

        result.onSuccess(::buildProducts)
    }


    private fun buildProducts(menus: List<ProductCategory>?) {
        if (menus == null) return
        for (item in menus) {

            if (item.children != null) {
                buildProducts(item.children)
            }

            if (item.products == null || item.products.isEmpty()) {
                continue
            }

            largeOverline {
                id(item.id!!)
                value(item.name)
            }

            for (product in item.products.take(3)) {
                card {
                    id(product.productNumber!!)
                    title(product.name)
                    subtitle(product.formCode)
                    imageUrl(product.imageUrlOrNull)
                }
            }

            if (item.products.size > 3) {
                wideButton {
                    id("show-more-${item.id}")
                    text("Show All")
                }
            }
        }
    }

    fun submit(result: ResultOf<List<ProductCategory>>) {
        _currentResult = result
        requestModelBuild()
    }

}
