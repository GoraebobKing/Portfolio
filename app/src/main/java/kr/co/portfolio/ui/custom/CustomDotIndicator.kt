package kr.co.portfolio.ui.custom

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import kr.co.portfolio.R


/**
 * Created by kwon on 2020/09/22
 **/
class CustomDotIndicator
    @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr : Int = 0): LinearLayout(context, attrs, defStyleAttr) {

    private var dotSpace = 0f
    private var dotSelected = 0
    private var dotUnSelected = 0
    private var dotSelectColor = 0
    private var dotUnSelectColor = 0

    private var currentIndex = 0
    private var dotSize = 0

    private var arrayList = ArrayList<ImageView>()
    init {

        orientation  = HORIZONTAL
        attrs.let {

            val typeArray = context.obtainStyledAttributes(it, R.styleable.CustomDotIndicator)

            dotSpace = typeArray.getDimension(R.styleable.CustomDotIndicator_dot_space, 0f)
            dotSelected = typeArray.getDimension(R.styleable.CustomDotIndicator_dot_selected_size, 0f).toInt()
            dotUnSelected = typeArray.getDimension(R.styleable.CustomDotIndicator_dot_un_selected_size, 0f).toInt()
            dotSelectColor = typeArray.getColor(R.styleable.CustomDotIndicator_dot_selected_colr, Color.WHITE)
            dotUnSelectColor = typeArray.getColor(R.styleable.CustomDotIndicator_dot_un_selected_colr, Color.WHITE)

            if(dotSelected == 0) dotSelected = dotUnSelected

            typeArray.recycle()
        }

        currentIndex = 2
        dotSize = 5

        onDrawDotLayer()
        selectedDot()
    }

    private fun onDrawDotLayer(){

        for (i in 0 until dotSize){

            val imageView = ImageView(context)
            imageView.setBackgroundColor(dotUnSelectColor)
            val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            layoutParams.width = dotUnSelected
            layoutParams.height = dotUnSelected

            //마지막께 아니면
            if(i != dotSize - 1){
                layoutParams.rightMargin = dotSpace.toInt()
            }
            imageView.layoutParams = layoutParams
            addView(imageView)
            arrayList.add(imageView)
        }
    }

    private fun selectedDot(){

        arrayList.forEachIndexed { index, img ->

            val dotSize : Int
            val param = img.layoutParams as LayoutParams
            if(index == currentIndex){
                dotSize = dotSelected
                img.background = drawCircle(dotSelectColor)
            } else {
                dotSize = dotUnSelected
                img.background = drawCircle(dotUnSelectColor)
            }

            param.width = dotSize
            param.height = dotSize
            param.gravity = Gravity.CENTER

            img.layoutParams = param
        }
    }

    private fun drawCircle(backgroundColor: Int): GradientDrawable {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL
        shape.cornerRadii = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        shape.setColor(backgroundColor)
        return shape
    }

    fun setViewPager(viewpager : ViewPager){
        dotSize = viewpager.adapter?.count?:0
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                currentIndex = position
                selectedDot()
            }
        })
    }

    private fun toPx(size : Int) : Float = (size * Resources.getSystem().displayMetrics.density)
}