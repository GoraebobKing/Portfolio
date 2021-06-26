package kr.co.portfolio.ui.custom

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.util.Common.toPx

class MaxHeightRecyclerView constructor(
    context : Context,
    attrs : AttributeSet? = null
) : RecyclerView(context, attrs){

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        val heightSpec = MeasureSpec.makeMeasureSpec(285.toPx(context), MeasureSpec.AT_MOST)
        super.onMeasure(widthSpec, heightSpec)
    }
}