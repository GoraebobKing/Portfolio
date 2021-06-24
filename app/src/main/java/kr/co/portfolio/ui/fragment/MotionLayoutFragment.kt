package kr.co.portfolio.ui.fragment

import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentMotionBinding
import kr.co.portfolio.viewmodel.BaseViewModel

/**
 * Created by kwon on 2021/06/05
 **/
class MotionLayoutFragment : BaseFragment<FragmentMotionBinding, BaseViewModel>(){

    override fun getLayoutResId() = R.layout.fragment_motion
    override fun getViewModel() = null

    override fun viewInit() {

    }

    override fun initObserver() {
        super.initObserver()
    }
}