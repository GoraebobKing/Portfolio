package kr.co.kwonsample.ui.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by kwon on 2020/09/18
 **/
class TestView : View {

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    private fun init() {

        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


//        paint.setShadowLayer(20f, 20f, 30f,0xFF000000)

//        val squreRect = RectF()
//        squreRect.set(0f, 90f, width.toFloat(), height.toFloat())
//
//        val sizeWidth = width/5
//
//        val circleRect = RectF()
//        circleRect.set((sizeWidth*2+10).toFloat(), 0f, (sizeWidth*3-10).toFloat(), (sizeWidth-20).toFloat())
//
//        canvas?.drawRect(squreRect, paint)

        val firstPaint = Paint()
        firstPaint.color = Color.BLUE
        firstPaint.style = Paint.Style.FILL


        val secPaint = Paint()
        secPaint.color = Color.RED
        secPaint.style = Paint.Style.FILL

        val fourPaint = Paint()
        fourPaint.color = Color.GREEN
        fourPaint.style = Paint.Style.FILL

        val fivePaint = Paint()
        fivePaint.color = Color.YELLOW
        fivePaint.style = Paint.Style.FILL

        val sizeWidth = width/5

        val firstRectF = RectF()
        firstRectF.set(0f, 100f, sizeWidth.toFloat(), height.toFloat())

        val secRectF = RectF()
        secRectF.set(sizeWidth.toFloat(), 100f, (sizeWidth*2).toFloat(),  height.toFloat())

        val fourRectF = RectF()
        fourRectF.set((sizeWidth*3).toFloat(), 100f, (sizeWidth*4).toFloat(), height.toFloat())

        val fiveRectF = RectF()
        fiveRectF.set((sizeWidth*4).toFloat(), 100f, width.toFloat(), height.toFloat())

        canvas?.drawRect(firstRectF, firstPaint)
        canvas?.drawRect(secRectF, secPaint)
        canvas?.drawRect(fourRectF, fourPaint)
        canvas?.drawRect(fiveRectF, fivePaint)

        val circlePaint = Paint()
        circlePaint.color = Color.CYAN
        circlePaint.style = Paint.Style.FILL
        val circleRect = RectF()

        circleRect.set((sizeWidth*2+5).toFloat(), 0f, (sizeWidth*3-5).toFloat(), (sizeWidth-10).toFloat())

        canvas?.drawOval(circleRect, circlePaint)






    }
}