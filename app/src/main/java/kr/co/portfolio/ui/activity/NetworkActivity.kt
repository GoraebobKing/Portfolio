package kr.co.portfolio.ui.activity

import android.widget.Toast
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

    override fun initObserve() {
        viewModel.networkResult.observe(this, {

            when(it.first){

                NetworkViewModel.NetworkNavigator.NETWORK_SUCCESS -> {
                    Toast.makeText(this, it.second, Toast.LENGTH_SHORT).show()
                }

                NetworkViewModel.NetworkNavigator.NETWORK_ERROR -> {
                    Toast.makeText(this, it.second, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }


    fun networkCall(){
        viewModel.versionCheck()
    }
}