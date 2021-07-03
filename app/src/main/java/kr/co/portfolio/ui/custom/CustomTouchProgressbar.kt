package kr.co.portfolio.ui.custom

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import kr.co.portfolio.R
import kr.co.portfolio.util.Logger


/**
 * Created by kwon on 2021/06/30
 **/
class CustomTouchProgressbar constructor(
    context: Context,
    attributeSet: AttributeSet?
): View(context, attributeSet) {

    private val mPaint = Paint()
    private val defaultPaint = Paint()
    private val bitmapPaint = Paint()

    private var progressRect = RectF()
    private var progressPoint = PointF()

    private val storkWidth = 15f

    private var startAngle = 0f
//    private var endAngle = 90f

    private var touchAngle = 90f

    private var mTranslateX = 0
    private var mTranslateY = 0

    private var mArcRadius = 0

    private var mIndicatorIconX = 0
    private var mIndicatorIconY = 0

    private var pointIcon : Drawable?


    init {

        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = storkWidth
        mPaint.color = Color.RED
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.strokeJoin = Paint.Join.ROUND

        defaultPaint.isAntiAlias = true
        defaultPaint.style = Paint.Style.STROKE
        defaultPaint.strokeWidth = storkWidth
        defaultPaint.color = Color.GRAY

        bitmapPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)

        pointIcon = ContextCompat.getDrawable(context, R.drawable.ic_point)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val w = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val h = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val min = Math.min(w, h)

        val arcDiameter = min - paddingLeft
        mArcRadius = arcDiameter / 2

        mTranslateX = (w * 0.5f).toInt()
        mTranslateY = (h * 0.5f).toInt()

        progressRect.set(
            storkWidth,
            storkWidth,
            w.toFloat() - storkWidth,
            h.toFloat() - storkWidth
        )

        progressPoint.x = progressRect.centerX()
        progressPoint.y = progressRect.centerY()

        Logger.e("onMeasure : $w   $h  $mTranslateX  $mTranslateY  $mArcRadius")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
//            val rectF = RectF(
//                storkWidth,
//                storkWidth,
//                width.toFloat() - storkWidth,
//                height.toFloat() - storkWidth
//            )
            it.drawArc(progressRect, 0f, 360f, false, defaultPaint)
            it.drawArc(progressRect, -90f, touchAngle, false, mPaint)

//            //처음 12시 방향 포인트에 버튼 찎기
            getBitmapFromVectorDrawable()?.let { draw ->
                it.drawBitmap(draw, 0f, 0f, bitmapPaint)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action){

            MotionEvent.ACTION_UP -> {

            }

            MotionEvent.ACTION_MOVE -> {
                val point = PointF(event.x, event.y)
                touchOnAngle(point)
            }

            MotionEvent.ACTION_DOWN -> {

            }

        }

        return true
    }

    private fun touchOnAngle(point: PointF) {

        touchAngle = Math.round(rotationToDegrees(point)).toFloat()

        mIndicatorIconX = (mArcRadius * Math.cos(Math.toRadians(touchAngle.toDouble()))).toLong().toInt()
        mIndicatorIconY = (mArcRadius * Math.sin(Math.toRadians(touchAngle.toDouble()))).toLong().toInt()

        Logger.e("angle :  $touchAngle  $mIndicatorIconX,  $mIndicatorIconY")
        invalidate()
    }

    private fun rotationToDegrees(point: PointF) : Double {
        val theta = Math.atan2(
            (point.y - progressPoint.y).toDouble(),
            (point.x - progressPoint.x).toDouble()
        )
        var angle = Math.toDegrees(theta)

        angle += 90

        if(angle < 0){
            angle += 360
        }

        return angle
    }

//    //벡터이미지 들고오기
    private fun getBitmapFromVectorDrawable(): Bitmap? {

        var bitmap : Bitmap? = null
        context?.let {

            bitmap = Bitmap.createBitmap(
                pointIcon?.intrinsicWidth ?: 0,
                pointIcon?.intrinsicHeight ?: 0, Bitmap.Config.ARGB_8888
            )
        }
        return bitmap
    }
}