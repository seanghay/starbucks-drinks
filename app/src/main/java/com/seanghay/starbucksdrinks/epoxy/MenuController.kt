package com.seanghay.starbucksdrinks.epoxy

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import com.seanghay.resultof.ResultOf
import com.seanghay.starbucksdrinks.data.MenuResponse

class MenuController : EpoxyController(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {

    private var _currentResult: ResultOf<MenuResponse>? = null

    override fun buildModels() {
        failureModelView {
            id("failure")
        }
    }


    fun submit(result: ResultOf<MenuResponse>) {

    }

}
