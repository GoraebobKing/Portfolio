package kr.co.portfolio.ui.fragment

import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentItemBinding
import kr.co.portfolio.viewmodel.ItemViewModel

class ItemFragment : BaseFragment<FragmentItemBinding, ItemViewModel>() {

    override fun getLayoutResId() = R.layout.fragment_item
    override fun getModelId() = ItemViewModel::class.java

    override fun viewInit() {

    }

    override fun initObserver() {

    }
}