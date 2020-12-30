package com.seanghay.starbucksdrinks.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.seanghay.starbucksdrinks.R
import com.seanghay.starbucksdrinks.databinding.ComponentCardBinding

@EpoxyModelClass(layout = R.layout.component_card)
abstract class CardModel : EpoxyModelWithHolder<CardModel.CardHolder>() {

    @field:EpoxyAttribute
    open var title: CharSequence? = null

    @field:EpoxyAttribute
    open var subtitle: CharSequence? = null

    @field:EpoxyAttribute
    open var imageUrl: String? = null

    override fun bind(holder: CardHolder) {
        holder.binding.apply {
            materialTextViewTitle.text = title
            materialTextViewSubtitle.text = subtitle
            Glide.with(imageView)
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .fitCenter().centerCrop()
                .into(imageView)
            root.setOnClickListener { }
        }
    }

    class CardHolder : EpoxyHolder() {

        lateinit var binding: ComponentCardBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentCardBinding.bind(itemView)
        }
    }
}