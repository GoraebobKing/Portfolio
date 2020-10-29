package kr.co.portfolio.dagger.remote

import kr.co.portfolio.data.ResultData
import kr.co.portfolio.data.User

/**
 * Created by kwon on 2020/10/15
 **/
interface RemoteDataSource {
    suspend fun getRepoUsers() : ResultData<List<User>>
}