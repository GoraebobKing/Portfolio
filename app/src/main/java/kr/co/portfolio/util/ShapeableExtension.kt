package kr.co.portfolio.util

import android.content.Context
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel
import kr.co.portfolio.util.Common.toPx

object ShapeableExtension {

    enum class ShapeableNavigator{
        ALL_CORNER, TOP_CORNER, BOTTOM_CORNER
    }

    fun ShapeableImageView.setCorner(
        context : Context,
        radius : Float,
        option : ShapeableNavigator
    ){
        var topLeft = 0.0f
        var topRight = 0.0f
        var bottomLeft = 0.0f
        var bottomRight = 0.0f

        when(option){

            ShapeableNavigator.ALL_CORNER -> {
                topLeft = radius.toPx(context)
                topRight = radius.toPx(context)
                bottomLeft = radius.toPx(context)
                bottomRight = radius.toPx(context)
            }

            ShapeableNavigator.TOP_CORNER -> {
                topLeft = radius.toPx(context)
                topRight = radius.toPx(context)
            }

            ShapeableNavigator.BOTTOM_CORNER -> {
                bottomLeft = radius.toPx(context)
                bottomRight = radius.toPx(context)
            }

        }

        shapeAppearanceModel = ShapeAppearanceModel().toBuilder()
            .setTopLeftCorner(CornerFamily.ROUNDED, topLeft)
            .setTopRightCorner(CornerFamily.ROUNDED, topRight)
            .setBottomLeftCorner(CornerFamily.ROUNDED, bottomLeft)
            .setBottomRightCorner(CornerFamily.ROUNDED, bottomRight)
            .build()
    }
}