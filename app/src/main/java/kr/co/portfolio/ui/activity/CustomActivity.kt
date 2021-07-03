package kr.co.portfolio.ui.activity

import android.graphics.BitmapFactory
import android.view.MotionEvent
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityCustomBinding
import kr.co.portfolio.util.Logger
import kr.co.portfolio.viewmodel.BaseViewModel

/**
 * Created by kwon on 2021/06/29
 **/
class CustomActivity : BaseActivity<ActivityCustomBinding, BaseViewModel>() {

    override fun getLayoutResId() = R.layout.activity_custom
    override fun getViewModel() : BaseViewModel? = null

    override fun initView() {

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}