package kr.co.portfolio.ui.fragment

import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentEmpty2Binding
import kr.co.portfolio.viewmodel.BaseViewModel

/**
 * Created by kwon on 2021/06/05
 **/
class EmptyFragment2 : BaseFragment<FragmentEmpty2Binding, BaseViewModel>(){

    override fun getLayoutResId() = R.layout.fragment_empty_2
    override fun getModelId() = BaseViewModel::class.java

    override fun viewInit() {

    }

    override fun initObserver() {
        super.initObserver()
    }
}