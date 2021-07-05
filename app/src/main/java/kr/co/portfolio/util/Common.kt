package kr.co.portfolio.util

import android.content.Context
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

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

    fun String.getSectionOfTextColor(
        context: Context,
        @ColorRes textColor: Int,
        fulltext: String,
        vararg textToColor: String,
    ): SpannableStringBuilder {
        val builder = SpannableStringBuilder(fulltext)

        for (textItem in textToColor) {
            if (textItem.isNotEmpty() && textItem.trim { it <= ' ' } != "") {
                //for counting start/end indexes
                val startingIndex = fulltext.indexOf(textItem)
                val endingIndex = startingIndex + textItem.length

                if (startingIndex >= 0 && endingIndex >= 0) {
                    builder.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, textColor)),
                        startingIndex,
                        endingIndex,
                        0
                    )
                }
            }
        }

        return builder
    }
}