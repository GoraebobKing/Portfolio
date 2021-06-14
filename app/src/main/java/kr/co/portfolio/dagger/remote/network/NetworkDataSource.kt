package kr.co.portfolio.dagger.remote.network


import kr.co.portfolio.network.module.NetworkResponse

/**
 * Created by kwon on 2021/06/10
 **/
interface NetworkDataSource {
    suspend fun versionCheck()
//    suspend fun versionCheck() : NetworkResponse<String>
}