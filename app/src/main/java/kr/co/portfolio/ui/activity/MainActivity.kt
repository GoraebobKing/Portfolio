package kr.co.portfolio.ui.activity

import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityMainBinding

import kr.co.portfolio.viewmodel.BaseViewModel


class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {

    override fun getLayoutResId() = R.layout.activity_main

    override fun getModelId() = BaseViewModel::class.java

    override fun initView() {
        binding.view = this
    }

    fun goToTabFragment(){

    }
}