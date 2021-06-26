package kr.co.portfolio.ui.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import kr.co.portfolio.viewmodel.BaseViewModel


/**
 * Created by kwon on 2020/09/24
 **/
abstract class BaseActivity<T : ViewDataBinding, U : BaseViewModel> : FragmentActivity() {

    @LayoutRes
    abstract fun getLayoutResId(): Int             //레이아웃 지정
    abstract fun getViewModel(): U?
    abstract fun initView()

    lateinit var binding : T

//    @Inject
//    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        AndroidInjection.inject(this)

        binding = DataBindingUtil.setContentView(this, getLayoutResId())

//        when(getModelId()){
//
//            BaseViewModel::class.java -> { }
//
//            else -> {
//                viewModel = ViewModelProviders.of(this, viewModelFactory).get(getModelId())
//            }
//        }

        initView()
        initObserve()
    }

    open fun initObserve(){

        getViewModel()?.errorResponse?.observe(this,{
            
        })
    }




}