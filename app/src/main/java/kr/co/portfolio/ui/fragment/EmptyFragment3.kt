package kr.co.portfolio.ui.fragment

import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentEmpty3Binding
import kr.co.portfolio.viewmodel.BaseViewModel

/**
 * Created by kwon on 2021/06/05
 **/
class EmptyFragment3 : BaseFragment<FragmentEmpty3Binding, BaseViewModel>(){

    override fun getLayoutResId() = R.layout.fragment_empty_3
    override fun getViewModel() = null

    override fun viewInit() {

    }

    override fun initObserver() {
        super.initObserver()
    }
}