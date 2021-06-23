package kr.co.portfolio.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
//import kr.co.portfolio.dagger.remote.network.NetworkDataSourceImpl
import javax.inject.Inject

/**
 * Created by kwon on 2021/06/12
 **/
//class NetworkViewModel @Inject constructor(private val repo: NetworkDataSourceImpl): BaseViewModel(){
//
//    enum class NetworkNavigator{
//        NETWORK_SUCCESS, NETWORK_ERROR
//    }
//
//    private var _networkResult : MutableLiveData<Pair<NetworkNavigator, String>> = MutableLiveData()
//    val networkResult : LiveData<Pair<NetworkNavigator, String>> = _networkResult
//
//    fun versionCheck(){
//        viewModelScope.launch {
//            repo.versionCheck(
//                {code, message ->
//                    _networkResult.postValue(Pair(NetworkNavigator.NETWORK_ERROR, message?:"Network Error"))
//                },
//                {
//                    _networkResult.postValue(Pair(NetworkNavigator.NETWORK_SUCCESS, ""))
//                }
//            )
//        }
//    }
//}
class NetworkViewModel : BaseViewModel(){

}