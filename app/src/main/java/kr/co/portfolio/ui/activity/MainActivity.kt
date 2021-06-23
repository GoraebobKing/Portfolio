package kr.co.portfolio.ui.activity

import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityMainBinding

import kr.co.portfolio.viewmodel.BaseViewModel


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {
        binding.view = this
    }

    fun goToTabFragment(){

    }

    fun goToNetworkActivity(){

        Intent(this, NetworkActivity::class.java).apply {
            startActivity(this)
        }
    }

    fun goToItemActivity(){

        Intent(this, ItemTabActivity::class.java).apply {
            startActivity(this)
        }
    }
}