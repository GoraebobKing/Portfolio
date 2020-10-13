package kr.co.portfolio.ui.fragment

import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentRxBinding
import kr.co.portfolio.ui.fragment.BaseFragment

/**
 * Created by kwon on 2020/09/07
 **/
class RxKotlinFragment : BaseFragment<FragmentRxBinding>() {

    override fun getLayoutResId() = R.layout.fragment_rx
    override fun getBackFlag() = false
    override fun backKeyUser() {}



    override fun onDestroy() {
        super.onDestroy()

    }

    override fun viewInit() {

        binding.fragment = this

        with(binding){


        }

    }
}