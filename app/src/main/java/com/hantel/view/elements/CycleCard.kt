package com.hantel.view.elements

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.hantel.R

class CycleCard(context: Context?, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {

    init {
        this.background = ContextCompat.getDrawable(this.context, R.drawable.background_blue_gradient)
        this.orientation = VERTICAL
        for(i in (0..5)) {
            val bar = CycleProgressBar(context, attributeSet)
            bar.layoutParams = LayoutParams(400, 70)
            this.addView(bar)
        }
    }
}