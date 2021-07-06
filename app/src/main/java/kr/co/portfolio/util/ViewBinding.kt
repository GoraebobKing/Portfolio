package kr.co.portfolio.util

import android.graphics.drawable.AnimationDrawable
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by kwon on 2021/06/04
 **/
object ViewBinding {

    @JvmStatic
    @BindingAdapter("animStart")
    fun bindAniStart(view: View, isStart: Boolean) {
        val animationDrawable = view.background as AnimationDrawable
        if (isStart) {
            view.post {
                animationDrawable.start()
            }
        } else {
            view.post {
                animationDrawable.stop()
            }
        }
    }

    @JvmStatic
    @BindingAdapter("visible")
    fun bindVisible(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}