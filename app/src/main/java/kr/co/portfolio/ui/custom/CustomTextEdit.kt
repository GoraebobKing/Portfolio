package kr.co.portfolio.ui.custom

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.InputType
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import kr.co.portfolio.R

/**
 * Created by kwon on 2020/09/22
 **/
class CustomTextEdit : AppCompatEditText {

    private var isDelete = false        //기본 삭제 아이콘 설정 체크
    private var isPasswd = false        //패스워드 인지 아닌지 체크

    private var underLineColor = Color.WHITE    //밑줄 라인 색상
    private var activeLineColor =  Color.WHITE  //활성화 되었을경우 색상
    private var inactiveLineColor =  Color.WHITE    //비활성화 되었을 경우 색상
    private var underLineHeight = 1f

    private lateinit var deleteResource : Drawable
    private lateinit var passWdOnResource : Drawable
    private lateinit var passWdOffResource : Drawable

    private var inputTypeCheck = 0

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){

        attrs.let {
            val typeArray = context.obtainStyledAttributes(it, R.styleable.CustomTextEdit)

//            typeArray.getResourceId(R.styleable.CustomTextEdit_img_active, R.drawable.ic_password_eye_on)
//            typeArray.getResourceId(R.styleable.CustomTextEdit_img_inactive, 0)

            activeLineColor = typeArray.getColor(R.styleable.CustomTextEdit_lineColor_active, 0)
            inactiveLineColor = typeArray.getColor(R.styleable.CustomTextEdit_lineColor_inactive, 0)

            underLineHeight = typeArray.getDimension(R.styleable.CustomTextEdit_lineHeight, 1f)

            isDelete = typeArray.getBoolean(R.styleable.CustomTextEdit_is_delete, false)
            isPasswd = typeArray.getBoolean(R.styleable.CustomTextEdit_is_passwd, false)

            deleteResource = context.getDrawable(R.drawable.ic_start_delete)!!
            passWdOnResource = context.getDrawable(R.drawable.ic_password_eye_on)!!
            passWdOffResource = context.getDrawable(R.drawable.ic_password_eye_off)!!

            typeArray.recycle()
        }

        deleteResource.setBounds(0, 0, deleteResource.intrinsicWidth, deleteResource.intrinsicHeight)
        passWdOnResource.setBounds(0, 0, passWdOnResource.intrinsicWidth, passWdOnResource.intrinsicHeight)
        passWdOffResource.setBounds(0, 0, passWdOffResource.intrinsicWidth, passWdOffResource.intrinsicHeight)

        inputTypeCheck = if(inputType == InputType.TYPE_CLASS_TEXT) InputType.TYPE_CLASS_TEXT else InputType.TYPE_CLASS_NUMBER
        isRightImgSetting()

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if(event?.action == MotionEvent.ACTION_UP ){

            if(isDelete && text.toString().isNotEmpty()){

                if(isCorrectTouch(event.x, deleteResource)){
                    setText("")
                }
            }

            if(isPasswd  && text.toString().isNotEmpty() ){

                if(inputType == InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD){
                    if(isCorrectTouch(event.x, passWdOffResource)){
                        inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    }
                } else if(inputType == InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD){
                    if(isCorrectTouch(event.x, passWdOnResource)){
                        inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    }
                }
            }
            isRightImgSetting()

        }

        return super.onTouchEvent(event)
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if(text.toString().isNotBlank()){
            isRightImgSetting()
        } else {
            setImage(false, null)
        }

        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {

        underLineColor = if(focused) activeLineColor else inactiveLineColor
        invalidate()
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val underPaint = Paint()
        underPaint.style = Paint.Style.FILL_AND_STROKE
        underPaint.color = underLineColor

        val underRectF = RectF()
        underRectF.set(0f, height.toFloat() - underLineHeight, width.toFloat(), height.toFloat())
        canvas?.drawRect(underRectF, underPaint)


    }

    private fun setImage(focus : Boolean, drawable : Drawable?){
        setCompoundDrawables(
            null,
            null,
            if(focus) drawable else null,
            null
        )
    }

    private fun isRightImgSetting(){

        if(isPasswd && text.toString().isNotEmpty() && inputType == InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD){

            setImage(hasFocus(), passWdOnResource)
        }

        if(isPasswd && text.toString().isNotEmpty() && inputType == InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD){

            setImage(hasFocus(), passWdOffResource)
        }

        if(isDelete && text.toString().isNotEmpty()) {

            setImage(hasFocus(), deleteResource)
        }

        invalidate()
    }

    private fun isCorrectTouch(eventX: Float, drawable : Drawable) : Boolean{
        return (eventX <= width - paddingRight && eventX >= width - paddingRight - drawable.bounds.width())
    }
}