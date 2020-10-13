package kr.co.portfolio.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by kwon on 2020/10/13
 **/


class ViewModelFactory @Inject constructor(
    private val viewModelMap : Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModelMap[modelClass]?.get() as T
    }
}