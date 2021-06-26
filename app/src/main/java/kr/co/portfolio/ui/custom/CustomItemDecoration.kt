package kr.co.portfolio.ui.custom

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomItemDecoration(
    private val dividerHeight : Int,
    private val dividerColor : Int,
    private val dividerLeftMargin : Int,
    private val dividerRightMargin : Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = dividerHeight
        val position = parent.getChildAdapterPosition(view)

        if(parent.adapter != null && position == (parent.adapter?.itemCount?.minus(1))){
            outRect.set(
                0,0,0,0
            )
        } else {
            super.getItemOffsets(outRect, view, parent, state)
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        Paint().apply{
            color = dividerColor
            isAntiAlias = true
            style = Paint.Style.FILL_AND_STROKE

            for (i in 0 until parent.childCount) {

                val child = parent.getChildAt(i)
                val param = child.layoutParams as RecyclerView.LayoutParams

                val dividerTop =  child.bottom + param.bottomMargin
                val dividerBottom = dividerTop + dividerHeight

                c.drawRect(
                    (child.left + dividerLeftMargin).toFloat(),
                    dividerTop.toFloat(),
                    (child.right + dividerRightMargin).toFloat(),
                    dividerBottom.toFloat(),
                    this
                )
            }
        }
    }
}