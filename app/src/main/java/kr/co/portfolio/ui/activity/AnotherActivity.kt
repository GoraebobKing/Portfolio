package kr.co.portfolio.ui.activity

import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityDaggerBinding
import kr.co.portfolio.viewmodel.BaseViewModel

/**
 * Created by kwon on 2020/10/13
 **/
class AnotherActivity : BaseActivity<ActivityDaggerBinding, BaseViewModel>() {

    override fun getLayoutResId() = R.layout.activity_another
    override fun getViewModel(): BaseViewModel? {
        return null
    }

    override fun initView() {

    }
}