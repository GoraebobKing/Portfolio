package kr.co.portfolio.ui.fragment

import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentCustomBinding
import kr.co.portfolio.viewmodel.BaseViewModel
import java.util.*

/**
 * Created by kwon on 2020/09/04
 **/
class CustomFragment : BaseFragment<FragmentCustomBinding, BaseViewModel>() {

    override fun getLayoutResId() = R.layout.fragment_custom
    override fun getModelId() = BaseViewModel::class.java

    override fun viewInit() {
        binding.fragment = this


    }
}