package com.seanghay.starbucksdrinks.epoxy

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController

class MenuController: EpoxyController(EpoxyAsyncUtil.getAsyncBackgroundHandler(), EpoxyAsyncUtil.getAsyncBackgroundHandler()) {

    override fun buildModels() {
        overline {
            id("overline-1")
            value("Popular Drinks")
        }
        repeat(3) {
            card {
                id(it)
            }
        }

        loaderModelView {
            id("loader02")
        }
    }

}
