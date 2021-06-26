package kr.co.portfolio.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * Created by kwon on 2020/09/24
 **/
open class BaseViewModel : ViewModel() {

    enum class BaseExceptionNavigator {
        NETWORK_ERROR
    }

    var responseJob = Dispatchers.IO + Job()


    //로딩바
    var isLoadingData = MutableLiveData<Boolean>()

    //통신 에러 처리
    var errorResponse = MutableLiveData<Pair<BaseExceptionNavigator, String>>()
    var errorLaunch : () -> Unit = {}
}