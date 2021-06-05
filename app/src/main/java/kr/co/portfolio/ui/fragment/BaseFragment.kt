package kr.co.portfolio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by kwon on 2020/09/03
 **/
abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    @LayoutRes
    abstract fun getLayoutResId() : Int
    abstract fun viewInit()

    open fun initObserver(){}

    lateinit var binding : T

    var mView : View? = null

    //공통 데이터 바인딩 처리
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(mView == null){
            binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
            binding.lifecycleOwner = this

            viewInit()

            mView = binding.root
        }

        return mView
    }
}