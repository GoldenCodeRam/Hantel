package com.hantel.view.elements

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.hantel.R


class CycleMenuElement(context: Context?, attrs: AttributeSet?) :
    ProgressBar(context, attrs, R.style.Widget_AppCompat_ProgressBar_Horizontal),
    View.OnClickListener {
    init {
        this.background = ContextCompat.getDrawable(this.context, R.drawable.background_gray_round)
        val a: TypedArray = this.context.obtainStyledAttributes(
            attrs,
            R.styleable.CycleMenuElement
        )
        a.recycle()
        this.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        Log.i("Test", "For das generalitat")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.i("Information: ", "${this.width}");
        val minw: Int = this.paddingLeft + this.paddingRight + this.suggestedMinimumWidth
        val w: Int = View.resolveSizeAndState(
            minw,
            widthMeasureSpec,
            1
        )
        val minh: Int = this.paddingTop + this.paddingBottom + this.suggestedMinimumHeight
        val h: Int = View.resolveSizeAndState(
            minh,
            heightMeasureSpec,
            1
        )
        Log.i("Information: ", "w: $w, h: $h")
        this.setMeasuredDimension(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val color: Int = ContextCompat.getColor(this.context, R.color.colorPrimaryDark)
        val icon: VectorDrawableCompat =
            VectorDrawableCompat.create(this.context.resources, R.drawable.ic_abs, null)!!
        icon.setBounds(0, 0, (this.height) / 2, (this.height / 2))
        canvas.save()
        canvas.translate((this.height / 4).toFloat(), (this.height / 4).toFloat())
        icon.draw(canvas)
        canvas.restore()
        canvas.drawLine(0f, 0f, 100f, 200f, Paint(Paint.ANTI_ALIAS_FLAG).apply {
            this.color = color
        })
    }
}