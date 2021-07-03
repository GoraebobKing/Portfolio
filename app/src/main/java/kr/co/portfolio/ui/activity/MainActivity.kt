package kr.co.portfolio.ui.activity

import android.content.Intent
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityMainBinding

import kr.co.portfolio.viewmodel.BaseViewModel


class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {

    override fun getLayoutResId() = R.layout.activity_main
    override fun getViewModel(): BaseViewModel? {
        return null
    }

    override fun initView() {
        binding.view = this
    }

    fun goToCustomActivity(){
        Intent(this, CustomActivity::class.java).apply {
            startActivity(this)
        }
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