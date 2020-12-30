package com.seanghay.starbucksdrinks.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.seanghay.starbucksdrinks.R
import com.seanghay.starbucksdrinks.databinding.ComponentOverlineBinding

@EpoxyModelClass(layout = R.layout.component_overline)
abstract class OverlineModel : EpoxyModelWithHolder<OverlineModel.OverlineHolder>() {

    @field:EpoxyAttribute
    open var value: CharSequence? = null

    override fun bind(holder: OverlineHolder) {
        holder.binding.root.text = value
    }

    class OverlineHolder : EpoxyHolder() {
        lateinit var binding: ComponentOverlineBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentOverlineBinding.bind(itemView)
        }
    }
}