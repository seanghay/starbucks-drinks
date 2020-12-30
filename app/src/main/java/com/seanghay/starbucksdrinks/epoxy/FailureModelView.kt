package com.seanghay.starbucksdrinks.epoxy

import android.content.Context
import android.util.AttributeSet
import com.airbnb.epoxy.ModelView
import com.google.android.material.card.MaterialCardView
import com.seanghay.starbucksdrinks.R

@ModelView(defaultLayout = R.layout.component_alert)
class FailureModelView : MaterialCardView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}