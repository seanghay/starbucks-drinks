package com.seanghay.starbucksdrinks.epoxy

import android.graphics.Color
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.airbnb.epoxy.group
import com.seanghay.starbucksdrinks.R
import com.seanghay.starbucksdrinks.data.ProductItem
import java.util.concurrent.CopyOnWriteArrayList

class RecommendedController : EpoxyController(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {

    private val _featuredModels: CopyOnWriteArrayList<LargeHeroModel_> = CopyOnWriteArrayList()
    private val _popularDrinks: CopyOnWriteArrayList<ProductItem> = CopyOnWriteArrayList()
    private val _signatureDrinks: CopyOnWriteArrayList<ProductItem> = CopyOnWriteArrayList()
    private val _allDrinks: CopyOnWriteArrayList<ProductItem> = CopyOnWriteArrayList()

    fun submitAll(items: Collection<ProductItem>) {
        _allDrinks.clear()
        _allDrinks.addAll(items)
        requestModelBuild()
    }


    fun submitSignatureDrinks(items: Collection<ProductItem>) {
        _signatureDrinks.clear()
        _signatureDrinks.addAll(items)
        requestModelBuild()
    }


    fun submitPopularDrinks(items: Collection<ProductItem>) {
        _popularDrinks.clear()
        _popularDrinks.addAll(items)
        requestModelBuild()
    }

    fun submitFeaturedProducts(items: Collection<ProductItem>) {
        _featuredModels.clear()
        _featuredModels.addAll(items.map {
            LargeHeroModel_().id("featured:" + it.productNumber)
                .imageUrl(it.imageUrlOrNull)
        })
        requestModelBuild()
    }

    override fun buildModels() {


        if (_featuredModels.isNotEmpty()) {
            overline {
                id("featured:overline")
                value("Featured Drinks")
            }

            group {
                id("group:carousel")
                layout(R.layout.component_layout_nested_scrollable_host)
                carousel {
                    id("carousel")
                    models(_featuredModels)
                    numViewsToShowOnScreen(2.1f)
                }
            }

        } else loaderModelView { id("featured:loader") }

        overline {
            id("popular-drink:overline")
            value("Popular Drinks")
        }

        if (_popularDrinks.isNotEmpty()) {
            for (_popularDrink in _popularDrinks) {
                card {
                    id("popular-drink:${_popularDrink.productNumber}")
                    imageUrl(_popularDrink.imageUrlOrNull)
                    title(_popularDrink.name)
                    subtitle(_popularDrink.formCode)
                }
            }
        } else loaderModelView { id("popular-drink:loader") }


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
            id("signature:overline")
            value("Signature Drinks")
        }

        if (_signatureDrinks.isNotEmpty()) {
            for (item in _signatureDrinks) {
                card {
                    id("signature:${item.productNumber}")
                    imageUrl(item.imageUrlOrNull)
                    title(item.name)
                    subtitle(item.formCode)
                }
            }
        } else loaderModelView { id("signature:loader") }


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
            id("cards:overline")
            value("Your cards")
        }

        failureModelView {
            id("failure")
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

        overline {
            id("all:overline")
            value("All Products")
        }

        if (_allDrinks.isNotEmpty()) {
            for (chunked in _allDrinks.chunked(5).withIndex()) {
                val isCarousel = chunked.index % 2 == 0

                if (isCarousel) {
                    for (item in chunked.value) {
                        card {
                            id("all:${item.productNumber}")
                            imageUrl(item.imageUrlOrNull)
                            title(item.name)
                            subtitle(item.formCode)
                        }
                    }
                } else {
                    val chuckedModels = chunked.value.map {
                        LargeHeroModel_().id("all:chunked:item:" + it.productNumber)
                            .imageUrl(it.imageUrlOrNull)
                    }

                    overline {
                        id("all:carousel:overline:${chunked.index}")
                        value("Related Products")
                    }
                    carousel {
                        id("all:carousel:${chunked.index}")
                        models(chuckedModels)
                        numViewsToShowOnScreen(3.2f)
                    }
                }


            }
        } else loaderModelView { id("all:loader") }

    }
}