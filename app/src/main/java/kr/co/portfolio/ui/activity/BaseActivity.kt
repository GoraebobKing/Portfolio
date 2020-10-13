package kr.co.portfolio.ui.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import kr.co.portfolio.viewmodel.BaseViewModel
import kr.co.portfolio.viewmodel.DaggerViewModel
import kr.co.portfolio.viewmodel.ViewModelFactory
import javax.inject.Inject

/**
 * Created by kwon on 2020/09/24
 **/
abstract class BaseActivity<T : ViewDataBinding, U : BaseViewModel> : AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutResId(): Int             //레이아웃 지정
    abstract fun getModelId(): Class<U>            //뷰모델 지정
    abstract fun initView()

    lateinit var binding : T
    lateinit var viewModel : U

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getModelId())

        initView()
    }


}