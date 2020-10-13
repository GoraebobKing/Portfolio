package kr.co.portfolio.ui.fragment

import android.content.Intent
import kr.co.portfolio.R
import kr.co.portfolio.databinding.FragmentHomeBinding
import kr.co.portfolio.ui.activity.AnotherActivity
import kr.co.portfolio.ui.activity.DaggerActivity

/**
 * Created by kwon on 2020/09/03
 * MotionLayout을 활용하였음
 **/
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getLayoutResId() = R.layout.fragment_home

    override fun getBackFlag() = true

    override fun backKeyUser() {

    }

    override fun viewInit() {

        binding.fragment = this
        binding.btn1.setOnClickListener {
            context?.let {ctx ->
                ctx.startActivity(Intent(ctx, DaggerActivity::class.java))
            }
        }

        binding.btn2.setOnClickListener {
            context?.let {ctx ->
                ctx.startActivity(Intent(ctx, AnotherActivity::class.java))
            }
        }
    }
}