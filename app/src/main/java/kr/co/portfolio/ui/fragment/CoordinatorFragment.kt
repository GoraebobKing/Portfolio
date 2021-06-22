package kr.co.portfolio.ui.fragment

import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentCoordinatorBinding
import kr.co.portfolio.ui.fragment.BaseFragment
import kr.co.portfolio.viewmodel.BaseViewModel


/**
 * Created by kwon on 2020/09/04
 * 코디네이터를 활용하여 스크롤시 상단바와 하단바가 사라지도록 UI작업을 함
 *
 **/
class CoordinatorFragment : BaseFragment<FragmentCoordinatorBinding, BaseViewModel>(){

    override fun getLayoutResId() = R.layout.fragment_coordinator
    override fun getModelId() = BaseViewModel::class.java

    override fun viewInit() {

        binding.webView.loadUrl("https://m.naver.com/")
        binding.nvScroll.viewTreeObserver.addOnScrollChangedListener {
            val scrollViewHeight =
                (binding.nvScroll.getChildAt(0).bottom - binding.nvScroll.height).toDouble()
            val getScrollY = binding.nvScroll.scrollY
            val scrollPosition = getScrollY / scrollViewHeight * 100.0
            binding.moveView.moveBarShow(scrollPosition.toFloat())
        }
    }




}