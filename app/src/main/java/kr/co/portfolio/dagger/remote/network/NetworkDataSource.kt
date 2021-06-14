package kr.co.portfolio.dagger.remote.network


import kr.co.portfolio.network.module.NetworkResponse

/**
 * Created by kwon on 2021/06/10
 **/
interface NetworkDataSource {
    suspend fun versionCheck(
        onError : (code : Int, message : String?) -> Unit,
        onComplete : () -> Unit)
//    suspend fun versionCheck() : NetworkResponse<String>
}