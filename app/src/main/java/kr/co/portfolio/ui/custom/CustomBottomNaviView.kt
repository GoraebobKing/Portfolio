package kr.co.portfolio.ui.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by kwon on 2020/09/18
 **/
class CustomBottomNaviView : View {

    private var mPath: Path = Path()
    private var mPaint: Paint = Paint()



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
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.color = Color.RED
        setBackgroundColor(Color.TRANSPARENT)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val rectPaint = Paint()
        rectPaint.color = Color.WHITE

        val rectPath = Path()

        val oneLayer = width/7

        rectPath.moveTo(0f, 100f)
        rectPath.lineTo((oneLayer*2 + oneLayer/2).toFloat(), 100f)

        rectPath.cubicTo(
            (oneLayer*2 + oneLayer/2).toFloat(), 100f,
            (oneLayer*2 + oneLayer/2 + oneLayer/4).toFloat(), 140f,
            (oneLayer*2 + oneLayer/2 + oneLayer/4 + oneLayer/4).toFloat(), 160f
        )

        rectPath.cubicTo(
            (oneLayer*2 + oneLayer/2 + oneLayer/4 + oneLayer/4).toFloat(), 100f,
            (oneLayer*2 + oneLayer/2 + oneLayer/4).toFloat(), 140f,
            (oneLayer*5 + oneLayer/2).toFloat(), 160f
        )

        rectPath.lineTo(width.toFloat(), 100f)
        rectPath.lineTo(width.toFloat(), 100f)
        rectPath.lineTo(width.toFloat(), height.toFloat())      //끄트머리
        rectPath.lineTo(0f, height.toFloat())
        rectPath.lineTo(0f, 100f)
        canvas.drawPath(rectPath, rectPaint)
    }
}