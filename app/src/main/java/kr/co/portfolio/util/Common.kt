package kr.co.portfolio.util

import android.content.Context
import android.util.TypedValue

/**
 * Created by kwon on 2021/06/05
 **/
object Common {

    fun Int.toPx(context : Context) : Int{
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }

    fun Float.toPx(context : Context) : Float{
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            context.resources.displayMetrics
        )
    }
}