package com.seanghay.starbucksdrinks.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.seanghay.starbucksdrinks.R
import com.seanghay.starbucksdrinks.databinding.ComponentWideButtonBinding


@EpoxyModelClass(layout = R.layout.component_wide_button)
abstract class WideButtonModel : EpoxyModelWithHolder<WideButtonModel.WideButtonHolder>() {

    @field:EpoxyAttribute
    open var text: CharSequence? = null

    override fun bind(holder: WideButtonHolder) {
        holder.binding.root.text = text
    }

    class WideButtonHolder : EpoxyHolder() {
        lateinit var binding: ComponentWideButtonBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentWideButtonBinding.bind(itemView)
        }
    }
}