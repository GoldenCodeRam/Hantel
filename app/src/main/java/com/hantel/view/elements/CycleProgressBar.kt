package com.hantel.view.elements

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.hantel.R


class CycleProgressBar(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatButton(
        context!!,
        attrs,
        R.style.Widget_AppCompat_Button_Borderless
    ),
    View.OnTouchListener {

    private var mBarHeight: Int = 0
    private var mBarWidth: Int = 0

    private val mProportionButtonHeight: Float = 0.8F
    private val mProportionLineHeight: Float = 0.7F

    init {
        this.isClickable = true
        val a: TypedArray = this.context.obtainStyledAttributes(
            attrs,
            R.styleable.CycleProgressBar
        )
        a.recycle()
        this.setOnTouchListener(this)
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        this.invalidate()
        return super.onTouchEvent(p1)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val minw: Int = this.paddingLeft + this.paddingRight + this.suggestedMinimumWidth
        this.mBarWidth = View.resolveSizeAndState(
            minw,
            widthMeasureSpec,
            1
        )
        val minh: Int = this.paddingTop + this.paddingBottom + this.suggestedMinimumHeight
        this.mBarHeight = View.resolveSizeAndState(
            minh,
            heightMeasureSpec,
            1
        )
        Log.d("BarDimensions", "${this.mBarWidth}, ${this.mBarHeight}")
        this.setMeasuredDimension(this.mBarWidth, this.mBarHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (this.isPressed) {
            this.drawPressed(canvas)
        } else {
            this.drawUnpressed(canvas)
        }
    }

    private fun drawPressed(canvas: Canvas) {
        canvas.drawRoundRect(
            0f,
            this.mBarHeight - (this.mBarHeight * this.mProportionButtonHeight),
            this.mBarWidth.toFloat(),
            this.mBarHeight.toFloat(),
            this.context.resources.getDimension(R.dimen.radius_normal),
            this.context.resources.getDimension(R.dimen.radius_normal),
            Paint(Paint.ANTI_ALIAS_FLAG).apply {
                this.color = context.getColor(R.color.colorGray)
            }
        )
        this.drawLines(canvas)
    }

    private fun drawUnpressed(canvas: Canvas) {
        val bottomPoint: Float = this.mBarHeight * this.mProportionButtonHeight
        canvas.drawRoundRect(
            0f,
            0f,
            this.mBarWidth.toFloat(),
            this.mBarHeight.toFloat(),
            this.context.resources.getDimension(R.dimen.radius_normal),
            this.context.resources.getDimension(R.dimen.radius_normal),
            Paint(Paint.ANTI_ALIAS_FLAG).apply {
                this.color = context.getColor(R.color.colorPrimaryDark)
            }
        )
        canvas.drawRoundRect(
            0f,
            0f,
            this.mBarWidth.toFloat(),
            bottomPoint,
            this.context.resources.getDimension(R.dimen.radius_normal),
            this.context.resources.getDimension(R.dimen.radius_normal),
            Paint(Paint.ANTI_ALIAS_FLAG).apply {
                this.color = context.getColor(R.color.colorGray)
            }
        )
        this.drawLines(canvas, bottomPoint)
    }

    private fun drawLines(canvas: Canvas, bottomPoint: Float = this.mBarHeight.toFloat()) {
        val lineSpacing: Float = (this.mBarWidth / 9).toFloat()
        for (i in (1..8)) {
            canvas.drawLine(
                lineSpacing * i,
                bottomPoint,
                lineSpacing * i,
                this.mBarHeight * this.mProportionLineHeight - (this.mBarHeight - bottomPoint),
                Paint(Paint.ANTI_ALIAS_FLAG).apply {
                    this.color = ContextCompat.getColor(context, R.color.colorPrimaryDarker)
                }
            )
        }
    }

    private fun drawIcon(canvas: Canvas) {
        val icon: VectorDrawableCompat =
            VectorDrawableCompat.create(this.context.resources, R.drawable.ic_abs, null)!!
        icon.setBounds(0, 0, (this.height) / 2, (this.height / 2))
        canvas.save()
        canvas.translate((this.height / 4).toFloat(), (this.height / 4).toFloat())
        icon.draw(canvas)
        canvas.restore()
    }
}