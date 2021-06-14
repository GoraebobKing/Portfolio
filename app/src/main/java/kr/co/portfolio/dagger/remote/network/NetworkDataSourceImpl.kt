package kr.co.portfolio.dagger.remote.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kr.co.portfolio.dagger.anno.IoDispatcher
import kr.co.portfolio.network.GithubApi
import kr.co.portfolio.network.module.NetworkResponse
import kr.co.portfolio.util.Logger


/**
 * Created by kwon on 2021/06/10
 **/
class NetworkDataSourceImpl constructor(
    private val service: GithubApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher) : NetworkDataSource {

    override suspend fun versionCheck() {

        withContext(ioDispatcher){
            val map = HashMap<String, Any>()
            map["apvOs"] = "A"

            when(val result = service.versionCheck(map)){

                is NetworkResponse.Success -> {
                    Logger.e("Network Success : $result")
                }

                is NetworkResponse.Error -> {
                    Logger.e("Network Error : $result")
                }
            }
        }
    }

    //    override suspend fun getRepoUsers() : ResultData<List<User>> =
//        withContext(ioDispatcher) {ResultData.Success(service.getRepoUsers()) }







    


}