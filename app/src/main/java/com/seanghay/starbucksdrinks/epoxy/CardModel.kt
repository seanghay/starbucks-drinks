package com.seanghay.starbucksdrinks.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.seanghay.starbucksdrinks.R
import com.seanghay.starbucksdrinks.databinding.ComponentCardBinding

@EpoxyModelClass(layout = R.layout.component_card)
abstract class CardModel : EpoxyModelWithHolder<CardModel.CardHolder>() {

    override fun bind(holder: CardHolder) {
        holder.binding.apply {
            materialTextViewTitle.text = "Caramel Brulée Latte"
            materialTextViewSubtitle.text = "Our signature espresso, steamed milk and rich caramel brulée sauce finished with whipped cream and a supreme topping of even more caramel brulée."
            Glide.with(imageView)
                .load("https://globalassets.starbucks.com/assets/c2a647e72ace4d2da35b1d7b56b05d12.jpg?impolicy=1by1_wide_1242")
                .fitCenter().centerCrop()
                .into(imageView)
            root.setOnClickListener {  }
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