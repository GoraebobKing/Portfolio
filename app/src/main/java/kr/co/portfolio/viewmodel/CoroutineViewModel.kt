package kr.co.portfolio.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.co.portfolio.dagger.remote.RemoteDataSourceImpl
import kr.co.portfolio.dagger.repo.RepositoryImpl
import kr.co.portfolio.data.User
import javax.inject.Inject

/**
 * Created by kwon on 2020/10/15
 **/
class CoroutineViewModel @Inject constructor(
    private val repositoryImpl: RepositoryImpl
) : BaseViewModel(){

    var last : MutableLiveData<List<User>> = MutableLiveData()

    fun test(){

        viewModelScope.launch {
            repositoryImpl.getRepoUsers()
//            last.value = repositoryImpl.getRepoUsers()
        }

    }
}