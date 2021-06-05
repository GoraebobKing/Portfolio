package kr.co.portfolio.util

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * Created by kwon on 2021/06/05
 **/
object FragmentExtension {

    enum class AnimationNavigation{
        NONE, BOTTOM_TO_TOP, LEFT_TO_RIGHT, RIGHT_TO_LEFT
    }


    /**
     * 기본페이지에서 사용할 프래그먼트 쌓는 형식
     * **/
    fun FragmentActivity.enterFragment(
        @IdRes layoutId : Int,
        fragment : Fragment,
        extras : Bundle? = null,
        anim : AnimationNavigation? = AnimationNavigation.NONE
    ){

        extras?.let {
            fragment.arguments = it
        }

        val fm = supportFragmentManager

        if(!fm.isStateSaved){

            val ft = fm.beginTransaction()

            when(anim){

                AnimationNavigation.BOTTOM_TO_TOP -> {

                }

                AnimationNavigation.LEFT_TO_RIGHT -> {

                }

                AnimationNavigation.RIGHT_TO_LEFT -> {

                }

                else -> { }
            }

            val value = fragment.toString()
            ft.addToBackStack(value)
            ft.replace(layoutId, fragment, value)
            ft.commitAllowingStateLoss()
        }
    }

    /**
     * 탭구조에서 가리고 보여주는데 사용하는 프래그먼트 형식
     * **/
    fun FragmentActivity.hideAndShowFragment(
        fragment : Fragment,
        extras : Bundle? = null,
    ){
        val fm = supportFragmentManager

        if(!fm.isStateSaved){

            val ft = fm.beginTransaction()
            var isFragmentAdd = false

            fm.fragments.forEach {
                if(it == fragment){
                    ft.show(it)
                    isFragmentAdd = true
                } else {
                    ft.hide(it)
                }
            }

            if(!isFragmentAdd){
                fragment.arguments = extras
            }

            ft.commitAllowingStateLoss()
        }
    }


}