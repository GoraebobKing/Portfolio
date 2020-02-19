package kr.co.portfolio.ui.activity

import android.os.Bundle
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}