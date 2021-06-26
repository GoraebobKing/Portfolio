package kr.co.portfolio.ui.bind.view

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

import com.google.android.material.imageview.ShapeableImageView
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.ui.adapter.ItemAdapter
import kr.co.portfolio.util.ShapeableExtension
import kr.co.portfolio.util.ShapeableExtension.setCorner

object ImageViewBind {

    @JvmStatic
    @BindingAdapter(value =[
        "loadUrl"
    ])
    fun imageViewLoadRadius(
        view : ShapeableImageView,
        loadUrl : String?
    ){
        loadUrl?.let {
            Glide.with(view.context)
                .load(it)
                .override(300, 300)
                .into(view)
        }

        view.setCorner(view.context, 8.0f, ShapeableExtension.ShapeableNavigator.ALL_CORNER)
    }
}