package kr.co.portfolio.ui.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kr.co.portfolio.R
import kr.co.portfolio.util.Logger


/**
 * Created by kwon on 2021/06/29
 **/
class CustomTestView constructor(
    context: Context, attributeSet: AttributeSet?
): View(context, attributeSet) {

    private var touchEnable = true

    private val paintLabel = Paint()
    private val paintCircle = Paint()
    private val paintOutLine = Paint()

    private val labelRect = Rect()
    private val circleRect = RectF()
    private val outRect = RectF()

    private val img : Bitmap

    private var totalW : Int = 0
    private var totalH : Int = 0

    private var labelAlpha = 100

    private val textLabel = "자~드가자"

    private val mTxtWidth : Float
    private val mTxtFontSize : Float = 55f

    private var startPointX = 0f
    private var movePointX = 0f

    init {

        paintCircle.style = Paint.Style.FILL
        paintCircle.color = Color.WHITE
        paintCircle.isAntiAlias = true
        paintCircle.strokeWidth = 1f

        paintOutLine.style = Paint.Style.FILL
        paintOutLine.color = Color.RED
        paintOutLine.isAntiAlias = true

        paintLabel.textSize = mTxtFontSize
        paintLabel.color = Color.BLACK
        paintLabel.style = Paint.Style.FILL
        paintLabel.isAntiAlias = true

        mTxtWidth = paintLabel.measureText(textLabel, 0, textLabel.length)

        val map = BitmapFactory.decodeResource(context.resources, R.drawable.ic_tab_health_off)
        img = Bitmap.createScaledBitmap(map, 80, 80, true)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        totalW = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        totalH = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)

        outRect.set(0f, 10f, totalW.toFloat(), totalH.toFloat() - 10f)
        circleRect.set(0f, 0f, totalH.toFloat(), totalH.toFloat())
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {

            it.drawRoundRect(outRect, 100f, 100f, paintOutLine)

            paintLabel.alpha = labelAlpha

            it.drawText(textLabel, (totalW/2 - mTxtWidth/2), (totalH/2 + 10f), paintLabel)
            it.drawArc(circleRect, 0f, 360f, false, paintCircle)
            it.drawBitmap(img, movePointX + totalH.toFloat()/2 - img.width/2, ((totalH - img.height + 10f)/2).toFloat() , null)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action){

            MotionEvent.ACTION_DOWN -> {
                startPointX = event.x
            }

            MotionEvent.ACTION_MOVE -> {
                Logger.e("start : $startPointX   end : ${event.x}     ${event.x - startPointX}")
                movePointX = event.x - startPointX
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                movePointX = 0f
            }
        }

        return true
    }


    private fun endSuccessCheck(){

    }
}