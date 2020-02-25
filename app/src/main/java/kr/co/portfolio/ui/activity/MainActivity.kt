package kr.co.portfolio.ui.activity

import android.os.Bundle
import androidx.core.view.GravityCompat
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init(){

        binding.mainModel = this
    }

    fun menuClick(){
        if(!binding.drawerLayout.isDrawerOpen(GravityCompat.END)){
            binding.drawerLayout.openDrawer(GravityCompat.END)
        }
    }

    fun menuClose(){
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.END)){
            binding.drawerLayout.closeDrawer(GravityCompat.END)
        }
    }
}