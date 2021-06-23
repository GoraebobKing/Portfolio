package kr.co.portfolio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kr.co.portfolio.BR
//import kr.co.portfolio.dagger.anno.ViewModelFactory
import kr.co.portfolio.viewmodel.BaseViewModel
import javax.inject.Inject

/**
 * Created by kwon on 2020/09/03
 **/
abstract class BaseFragment<T : ViewDataBinding, U : BaseViewModel> : Fragment() {

    @LayoutRes
    abstract fun getLayoutResId() : Int
    abstract fun getModelId(): Class<U>
    abstract fun viewInit()

    open fun initObserver(){}

    lateinit var binding : T
    lateinit var viewModel : U

//    @Inject
//    lateinit var viewModelFactory: ViewModelFactory

    var mView : View? = null

    //공통 데이터 바인딩 처리
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(mView == null){
            binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
            binding.lifecycleOwner = this

//            when(getModelId()){
//
//                BaseViewModel::class.java -> { }
//
//                else -> {
//                    viewModel = ViewModelProviders.of(this, viewModelFactory).get(getModelId())
//                }
//            }
//
//            binding.setVariable(BR.view, binding)
//            binding.setVariable(BR.vm, viewModel)

            viewInit()

            mView = binding.root
        }

        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObserver()
    }
}