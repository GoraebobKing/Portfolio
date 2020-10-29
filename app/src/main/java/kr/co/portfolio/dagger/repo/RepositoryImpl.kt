package kr.co.portfolio.dagger.repo

import kotlinx.coroutines.CoroutineDispatcher
import kr.co.portfolio.dagger.anno.IoDispatcher
import kr.co.portfolio.dagger.remote.RemoteDataSource
import kr.co.portfolio.data.ResultData
import kr.co.portfolio.data.User

/**
 * Created by kwon on 2020/10/15
 **/
class RepositoryImpl constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher) : Repository {

    override suspend fun getRepoUsers(): ResultData<List<User>> {

        return when(val result = remoteDataSource.getRepoUsers()){

            is ResultData.Success -> {
                val response = result.data
                ResultData.Success(response)
            }

            is ResultData.Error -> {
                val response = result.data
                ResultData.Error(response, "ERROR")
            }
        }

    }

}