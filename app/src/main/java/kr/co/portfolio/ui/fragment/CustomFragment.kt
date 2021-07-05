package kr.co.portfolio.ui.fragment

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.suspendCancellableCoroutine
import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentCustomBinding
import kr.co.portfolio.viewmodel.BaseViewModel
import java.util.*

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