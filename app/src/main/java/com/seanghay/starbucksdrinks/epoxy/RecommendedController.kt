package com.seanghay.starbucksdrinks.epoxy

import android.graphics.Color
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel

class RecommendedController : EpoxyController(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {

    private val featuredModels = (0..10).map {
        LargeHeroModel_().id("large-$it").imageUrl("https://globalassets.starbucks.com/assets/1039a0883ad548b69c5f93b9f76dbae2.jpg?impolicy=1by1_wide_1242")
    }

    override fun buildModels() {
        overline {
            id("overline-0")
            value("Featured Drinks")
        }

        carousel {
            id("carousel")
            models(featuredModels)
            numViewsToShowOnScreen(1.4f)
        }

        overline {
            id("overline-1")
            value("Popular Drinks")
        }
        repeat(3) {
            card {
                id(it)
            }
        }

        wideButton {
            id("button-more")
            text("View More")
        }

        eventHero {
            id("hero-event")
            headingText("Starbucks for Life")
            bodyText("Play for the chance to win more than 2.5 million prizes, like free coffee, Bonus Stars, Bose QuietComfort® Earbuds, Alaska Airlines travel vouchers and more!**")
            buttonText("Join the festivities")
            imageUrl("https://content-prod-live.cert.starbucks.com/binary/v2/asset/137-67450.png")
            clickListener { _ ->
                // TODO: impl
            }

            backgroundColor(Color.parseColor("#1a3c34"))
        }

        overline {
            id("overline-3")
            value("Signature Drinks")
        }
        repeat(3) {
            card {
                id(it)
            }
        }

        overline {
            id("overline-3")
            value("Rewards")
        }

        eventHero {
            id("hero-event-2")
            headingText("Earning 4,500 Bonus Stars is Super Starifying")
            bodyText("\$0 intro annual fee for your first year with the Starbucks® Rewards Visa® Card. Plus your Stars won’t expire—an exclusive Starbucks benefit for cardmembers. Now that’s Super Starifying.***")
            buttonText("Learn More")
            imageUrl("https://content-prod-live.cert.starbucks.com/binary/v2/asset/137-67558.jpg")
            clickListener { _ ->
                // TODO: impl
            }
            backgroundColor(Color.parseColor("#1a3c34"))
        }


        overline {
            id("overline-11")
            value("Food")
        }

        carousel {
            id("carousel-2")
            models(featuredModels)
            numViewsToShowOnScreen(2.5f)
        }


        overline {
            id("overline-3")
            value("Seasonal Drinks")
        }

        eventHero {
            id("hero-event-3")
            headingText("HOLIDAY YOUR WAY")
            bodyText("So many convenient ways to get your festive favorites.")
            buttonText("Explore seasonal drinks")
            imageUrl("https://content-prod-live.cert.starbucks.com/binary/v2/asset/137-66306.png")
            clickListener { _ ->
                // TODO: impl
            }
            backgroundColor(Color.parseColor("#e1251b"))
        }


        loaderModelView {
            id("loader")
        }
    }
}