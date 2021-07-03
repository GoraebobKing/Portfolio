package kr.co.portfolio.ui.activity

import androidx.activity.viewModels
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityItemDetailBinding
import kr.co.portfolio.viewmodel.ItemDetailViewModel

/**
 * Created by kwon on 2021/06/29
 **/
class ItemDetailActivity : BaseActivity<ActivityItemDetailBinding, ItemDetailViewModel>() {

    private val detailViewModel : ItemDetailViewModel by viewModels()

    override fun getLayoutResId() = R.layout.activity_item_detail
    override fun getViewModel() = detailViewModel

    override fun initView() {

    }

    override fun initObserve() {
        super.initObserve()
    }
}