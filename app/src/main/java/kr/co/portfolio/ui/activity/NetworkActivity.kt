package kr.co.portfolio.ui.activity

import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityNetworkBinding
import kr.co.portfolio.viewmodel.NetworkViewModel

/**
 * Created by kwon on 2021/06/12
 **/
class NetworkActivity : BaseActivity<ActivityNetworkBinding, NetworkViewModel>() {

    override fun getLayoutResId() = R.layout.activity_network

    override fun getModelId() = NetworkViewModel::class.java

    override fun initView() {
        binding.view = this
    }

    fun networkCall(){
        viewModel.versionCheck()
    }
}