package kr.co.portfolio.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kr.co.portfolio.R

/**
 * Created by kwon on 2020/09/17
 **/
class CustomBarView : View {

    private var bgColor = 0
    private var innerColor = 0
    private var roundCorner = 0.0f
    private var movePercentage = 0.0f

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attributeSet : AttributeSet) :  super(context, attributeSet) {
        attributeSet.let {
            val typeArray = context.obtainStyledAttributes(it, R.styleable.CustomBarView)

            bgColor = typeArray.getColor(R.styleable.CustomBarView_bg_color, Color.WHITE)
            innerColor = typeArray.getColor(R.styleable.CustomBarView_in_color, Color.WHITE)
            roundCorner = typeArray.getDimension(R.styleable.CustomBarView_corners, 0f)

            val gradientDrawable = GradientDrawable()
            gradientDrawable.mutate()
            gradientDrawable.setColor(bgColor)
            gradientDrawable.cornerRadius = roundCorner
//            gradientDrawable.cornerRadii = cornerArray

            background = gradientDrawable
            typeArray.recycle()
        }

    }


    fun moveBarShow(percentage : Float){

        movePercentage = percentage
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //색상
        val paint = Paint()
        paint.color = innerColor

        val percentage = width/200.toFloat()
        val moveIndex = percentage * movePercentage
//        canvas?.drawRect(0.0f, 0.0f, (width/2).toFloat(), height.toFloat(), paint)
        val rectF = RectF(0.0f + moveIndex, 0.0f, (width/2).toFloat() + moveIndex, height.toFloat())
        canvas?.drawRoundRect(rectF, roundCorner, roundCorner, paint)

        Log.e("onDraw", "onDraw = percentage : $percentage, movePercentage : $movePercentage, moveIndex : $moveIndex")
    }
}