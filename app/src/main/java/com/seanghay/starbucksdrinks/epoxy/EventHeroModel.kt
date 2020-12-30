package com.seanghay.starbucksdrinks.epoxy

import android.graphics.Color
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.seanghay.starbucksdrinks.R
import com.seanghay.starbucksdrinks.databinding.ComponentHeroEventBinding

@EpoxyModelClass(layout = R.layout.component_hero_event)
abstract class EventHeroModel : EpoxyModelWithHolder<EventHeroModel.EventHeroHolder>() {

    @field:EpoxyAttribute
    open var headingText: CharSequence? = null

    @field:EpoxyAttribute
    open var bodyText: CharSequence? = null

    @field:EpoxyAttribute
    open var buttonText: CharSequence? = null

    @field:EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    open var clickListener: View.OnClickListener? = null

    @field:EpoxyAttribute
    open var imageUrl: String? = null

    @field:EpoxyAttribute
    open var backgroundColor: Int? = null


    override fun bind(holder: EventHeroHolder) {
        holder.binding.apply {
            materialTextViewHeading.text = headingText
            materialTextViewBody.text = bodyText
            button.text = buttonText
            button.setOnClickListener(clickListener)
            Glide.with(imageView).load(imageUrl)
                .centerCrop().fitCenter().into(imageView)
            root.setBackgroundColor(backgroundColor ?: Color.MAGENTA)
        }
    }

    override fun unbind(holder: EventHeroHolder) {
        holder.binding.button.setOnClickListener(null)
    }

    class EventHeroHolder : EpoxyHolder() {

        lateinit var binding: ComponentHeroEventBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentHeroEventBinding.bind(itemView)
        }

    }
}