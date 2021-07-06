package kr.co.portfolio.ui.activity

import androidx.activity.viewModels
import kr.co.portfolio.R
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.databinding.ActivityItemDetailBinding
import kr.co.portfolio.util.Const
import kr.co.portfolio.viewmodel.ItemDetailViewModel

/**
 * Created by kwon on 2021/06/29
 **/
class ItemDetailActivity : BaseActivity<ActivityItemDetailBinding, ItemDetailViewModel>() {

    private val detailViewModel : ItemDetailViewModel by viewModels()

    override fun getLayoutResId() = R.layout.activity_item_detail
    override fun getViewModel() = detailViewModel

    override fun initView() {

        intent?.getParcelableExtra<ProductResponse>(Const.BUNDLE_PRODUCT)?.let {
            binding.item = it
        }
    }

    override fun initObserve() {
        super.initObserve()
    }
}