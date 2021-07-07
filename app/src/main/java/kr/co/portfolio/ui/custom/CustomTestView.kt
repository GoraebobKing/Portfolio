package kr.co.portfolio.ui.custom

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kr.co.portfolio.R
import kr.co.portfolio.util.Logger
import java.lang.ref.WeakReference


/**
 * Created by kwon on 2021/06/29
 **/
class CustomTestView constructor(
    context: Context, attributeSet: AttributeSet?
): View(context, attributeSet) {

    private var touchEnable = true
    private var isAnimationStart = false

    private val paintLabel = Paint()
    private val paintCircle = Paint()
    private val paintOutLine = Paint()

    private val labelRect = Rect()
    private val circleRect = RectF()
    private val outRect = RectF()

    private val img : Bitmap

    private var totalW : Int = 0
    private var totalH : Int = 0

    private var labelAlpha = 0

    private val textLabel = "자~드가자"

    private val mTxtWidth : Float
    private val mTxtFontSize : Float = 55f

    private var startPointX = 0f
    private var movePointX = 0f
    private var animatePointX = 0f

    private var mHandler: CustomHandler

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

        mHandler = CustomHandler(this)
    }

    fun reset(){
        labelAlpha = 0
        startPointX = 0f
        movePointX = 0f
        animatePointX = 0f
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

            //터치로 욺직일때마다 값을 세팅해야하는 부분
            paintLabel.alpha = 100 - labelAlpha/2
            circleRect.set( movePointX - animatePointX, 0f, movePointX + totalH.toFloat(), totalH.toFloat())

            it.drawText(textLabel, (totalW/2 - mTxtWidth/2), (totalH/2 + 10f), paintLabel)
//            it.drawArc(circleRect, 0f, 360f, false, paintCircle)
            it.drawRoundRect(circleRect, 100f, 100f, paintCircle)

            val animationDraw = if(isAnimationStart){
                movePointX - animatePointX/2 + totalH.toFloat()/2 - img.width/2
            } else {
                movePointX + totalH.toFloat()/2 - img.width/2
            }
            it.drawBitmap(img, animationDraw, ((totalH - img.height + 10f)/2) , null)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if(touchEnable){
            when(event?.action){

                MotionEvent.ACTION_DOWN -> {
                    Logger.e("MotionEvent.ACTION_DOWN")
                    startPointX = event.x
                }

                MotionEvent.ACTION_MOVE -> {

                    val x = event.x
                    if(x >= 0 && x <= totalW){
                        isAnimationStart = false
                        movePointX = if(event.x - startPointX >= totalW.toFloat() - totalH.toFloat()){

                            isAnimationStart = true
//                            Logger.e("111 : ${totalW.toFloat() - totalH.toFloat()}   $isAnimationStart")
                            totalW.toFloat() - totalH.toFloat()
                        } else if(event.x - startPointX <= 0) {
                            0f
                        } else {
//                            Logger.e("2222 : ${event.x - startPointX}")
                            event.x - startPointX
                        }

                        labelAlpha = (movePointX/(totalW.toFloat() - totalH.toFloat())*100).toInt()
                        invalidate()
                    }

                    Logger.e("MotionEvent.ACTION_MOVE $isAnimationStart")
                }

                MotionEvent.ACTION_UP -> {
                    Logger.e("MotionEvent.ACTION_UP $isAnimationStart")
                    if(isAnimationStart){
                        runningAnimation()
                    } else {
                        movePointX = 0f
                        labelAlpha = 0
                        invalidate()
                    }
                }
            }
        }

        return true
    }


    private fun runningAnimation(){

        touchEnable = false
        mHandler.sendEmptyMessage(0)
    }

    class CustomHandler(host : CustomTestView) : Handler(Looper.getMainLooper()){
        private var mWeakRef: WeakReference<CustomTestView>? = null

        private val refreshPeriod = 1

        private var index = 0

        init {
            mWeakRef = WeakReference(host)
        }

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            Logger.e("start handleMessage")
            mWeakRef?.let {
                it.get()?.let { view ->

                    if(view.movePointX - view.animatePointX <= 0){
                        view.touchEnable = true
                        view.isAnimationStart = false
                    } else {
                        index += 5
                        view.animatePointX = index.toFloat()
                        view.invalidate()
                    }

                    if(view.isAnimationStart){
                        sendEmptyMessageDelayed(0, refreshPeriod.toLong())
                    } else {

                        Thread.sleep(1000)
                        index = 0
                        view.reset()
                        view.invalidate()
                    }
                }
            }
        }
    }
}