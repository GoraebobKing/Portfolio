package kr.co.portfolio.ui.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kr.co.portfolio.R


/**
 * Created by kwon on 2020/09/17
 **/
class CustomProgressView : View {

    private var endRadius = 0.0f
    private var progressWidth = 0.0f
    private var backProgressColor = 0
    private var startGradient = 0
    private var endGradient = 0
    private var txtColor = 0
    private var txtSize = 0.0f
    private var txt = ""
//    private var fontType =


    constructor(context: Context) : super(context, null)
    constructor(context: Context, attributeSet : AttributeSet) :  super(context, attributeSet) {
        attributeSet.let {
            val typeArray = context.obtainStyledAttributes(it, R.styleable.CustomProgressView)

            endRadius = typeArray.getDimension(R.styleable.CustomProgressView_end_radius, 0f)
            progressWidth = typeArray.getDimension(R.styleable.CustomProgressView_progress_width, 0f)
            backProgressColor = typeArray.getColor(R.styleable.CustomProgressView_back_progress, Color.WHITE)
            startGradient = typeArray.getColor(R.styleable.CustomProgressView_start_gradient, Color.WHITE)
            endGradient = typeArray.getColor(R.styleable.CustomProgressView_end_gradient, Color.WHITE)
            txtColor = typeArray.getColor(R.styleable.CustomProgressView_txt_color, Color.WHITE)
            txtSize = typeArray.getDimension(R.styleable.CustomProgressView_txt_size, 0f)
            typeArray.getString(R.styleable.CustomProgressView_txt)?.let {data ->
                txt = data
            }


//            val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,  intArrayOf(startGradient, endGradient))
//            background = gradientDrawable
            typeArray.recycle()
            invalidate()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //뒷 배경이 되는 원의 paint
        val backPaint = Paint()
        backPaint.color = backProgressColor
        backPaint.strokeWidth = progressWidth
        backPaint.isAntiAlias = false
        backPaint.style = Paint.Style.STROKE

        val rectF = RectF(progressWidth, progressWidth, width.toFloat() - progressWidth, height.toFloat() - progressWidth)

        canvas?.drawArc(rectF, 270f, 630f, false, backPaint)

        //안쪽으로 그려지는 원
        val inPaint = Paint()
        inPaint.strokeWidth = progressWidth
        inPaint.isAntiAlias = false
        inPaint.style = Paint.Style.STROKE
        inPaint.strokeCap = Paint.Cap.ROUND
//        inPaint.strokeJoin = Paint.Join.ROUND
//        inPaint.strokeMiter = 10f
//        inPaint.color = endGradient
//        inPaint.shader = SweepGradient( 270f, 180f, startGradient, endGradient)
        inPaint.shader = LinearGradient(progressWidth, progressWidth, width.toFloat() - progressWidth, height.toFloat() - progressWidth, startGradient, endGradient, Shader.TileMode.MIRROR)

        canvas?.drawArc(rectF, 270f, 180f, false, inPaint)

        val textRect = Rect()
        val textPaint = Paint()
        textPaint.isAntiAlias = true
        textPaint.color = txtColor
        textPaint.textSize = txtSize
        textPaint.getTextBounds(txt, 0, 3, textRect)


        canvas?.drawText(txt, (width/2 - textRect.width()/2).toFloat(), (height/2 + textRect.height()/2).toFloat(), textPaint)
    }
}