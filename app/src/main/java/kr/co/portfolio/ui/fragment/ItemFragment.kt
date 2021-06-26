package kr.co.portfolio.ui.fragment

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentItemBinding
import kr.co.portfolio.viewmodel.ItemViewModel

@AndroidEntryPoint
class ItemFragment : BaseFragment<FragmentItemBinding, ItemViewModel>() {

    override fun getLayoutResId() = R.layout.fragment_item
    override fun getViewModel() = itemViewModel

    private val itemViewModel : ItemViewModel by activityViewModels()


    override fun viewInit() {
        binding.view = this
        binding.vm = itemViewModel
    }

    override fun initObserver() {

    }
}