package kr.co.portfolio.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.co.portfolio.dagger.remote.network.NetworkDataSourceImpl
import javax.inject.Inject

/**
 * Created by kwon on 2021/06/12
 **/
class NetworkViewModel @Inject constructor(private val repo: NetworkDataSourceImpl): BaseViewModel(){

    fun versionCheck(){
        viewModelScope.launch {
            repo.versionCheck()
        }
    }
}