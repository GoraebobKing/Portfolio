package kr.co.portfolio.ui.fragment

import android.graphics.Color
import kr.co.portfolio.R
import kr.co.portfolio.data.PagerData
import kr.co.portfolio.databinding.FragmentRxBinding
import kr.co.portfolio.ui.adapter.CustomPageAdapter
import kr.co.portfolio.ui.adapter.Pager2Adapter
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
            val array = arrayListOf(
                PagerData("000", Color.RED),
                PagerData("111", Color.BLUE),
                PagerData("222", Color.BLACK),
                PagerData("333", Color.CYAN),
                PagerData("444", Color.DKGRAY),
                PagerData("555", Color.GRAY),
                PagerData("666", Color.GREEN),
                PagerData("777", Color.LTGRAY),
                PagerData("888", Color.MAGENTA))
            val adapter = CustomPageAdapter(array.size)
            adapter.updateData(array)
//            val adapter = Pager2Adapter()
//            adapter.updateData(array)
//            adapter.setOnCliked(object : Pager2Adapter.ClickEvent{
//                override fun onClicked() {
//                    if(pager2.currentItem == 0){
//                        pager2.setCurrentItem(1, true)
//                    } else {
//                        pager2.setCurrentItem(0, true)
//                    }
//                }
//            })

//            pager2.adapter = adapter
            pager.adapter = adapter
        }

    }
}