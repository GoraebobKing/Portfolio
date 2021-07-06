package kr.co.portfolio.ui.fragment

import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentCustomBinding
import kr.co.portfolio.viewmodel.BaseViewModel

/**
 * Created by kwon on 2020/09/04
 **/
class CustomFragment : BaseFragment<FragmentCustomBinding, BaseViewModel>() {

    override fun getLayoutResId() = R.layout.fragment_custom
    override fun getViewModel() = null

    override fun viewInit() {
        binding.fragment = this



    }
}