package kr.co.portfolio.ui.activity

import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityDaggerBinding
import kr.co.portfolio.viewmodel.AnotherViewModel

/**
 * Created by kwon on 2020/10/13
 **/
class AnotherActivity : BaseActivity<ActivityDaggerBinding, AnotherViewModel>() {

    override fun getLayoutResId() = R.layout.activity_another
    override fun getModelId() = AnotherViewModel::class.java

    override fun initView() {
        viewModel.startApi()
    }
}