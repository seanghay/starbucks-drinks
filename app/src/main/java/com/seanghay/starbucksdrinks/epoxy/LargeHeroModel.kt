package com.seanghay.starbucksdrinks.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.seanghay.starbucksdrinks.R
import com.seanghay.starbucksdrinks.databinding.ComponentLargeHeroBinding

@EpoxyModelClass(layout = R.layout.component_large_hero)
abstract class LargeHeroModel : EpoxyModelWithHolder<LargeHeroModel.LargeHeroHolder>() {

    @field:EpoxyAttribute
    open var imageUrl: String? = null

    override fun bind(holder: LargeHeroHolder) {
        val imageView = holder.binding.imageView
        Glide.with(imageView).load(imageUrl)
            .fitCenter()
            .centerCrop()
            .into(imageView)
    }

    class LargeHeroHolder : EpoxyHolder() {
        lateinit var binding: ComponentLargeHeroBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentLargeHeroBinding.bind(itemView)
        }
    }
}