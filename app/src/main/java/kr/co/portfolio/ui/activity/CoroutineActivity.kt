package kr.co.portfolio.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import dagger.android.AndroidInjection
import kotlinx.coroutines.*
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityCoroutineBinding
import kr.co.portfolio.network.GithubApi
import kr.co.portfolio.viewmodel.CoroutineViewModel
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by kwon on 2020/10/14
 **/
class CoroutineActivity : BaseActivity<ActivityCoroutineBinding, CoroutineViewModel>() {


    private val TAG = "CoroutineActivity"

    override fun getLayoutResId() = R.layout.activity_coroutine
    override fun getModelId() = CoroutineViewModel::class.java

    override fun initView() {
        viewModel.test()

//        viewModel.last.observe(this, Observer {
//
//        })
    }
}