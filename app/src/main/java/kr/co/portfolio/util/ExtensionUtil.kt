package kr.co.portfolio.util

import android.view.View

/**
 * Created by kwon on 2021/02/08
 **/

fun View.visible() {
    if(this.visibility != View.VISIBLE) this.visibility = View.VISIBLE
}

fun View.gone() {
    if(this.visibility != View.GONE) this.visibility = View.GONE
}

fun View.invisible() {
    if(this.visibility != View.INVISIBLE) this.visibility = View.INVISIBLE
}

