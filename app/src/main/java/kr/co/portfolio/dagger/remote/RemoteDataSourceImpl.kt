package kr.co.portfolio.dagger.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kr.co.portfolio.dagger.anno.IoDispatcher
import kr.co.portfolio.data.ResultData
import kr.co.portfolio.data.User
import kr.co.portfolio.network.GithubApi


/**
 * Created by kwon on 2020/10/15
 **/
class RemoteDataSourceImpl constructor(
    private val service: GithubApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher) : RemoteDataSource {


    override suspend fun getRepoUsers() : ResultData<List<User>> =
        withContext(ioDispatcher) {ResultData.Success(service.getRepoUsers()) }







    


}