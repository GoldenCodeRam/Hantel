package com.hantel.view.elements

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ProgressBar
import com.hantel.R

class CycleProgressBar(context: Context?, attrs: AttributeSet?) :
    ProgressBar(context, attrs, R.style.Widget_AppCompat_ProgressBar_Horizontal) {
    init {
        val a: TypedArray = this.context.obtainStyledAttributes(
            attrs,
            R.styleable.CycleProgressBar
        )
        a.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        
    }
}