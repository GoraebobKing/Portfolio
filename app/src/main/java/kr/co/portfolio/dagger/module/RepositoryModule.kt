package kr.co.portfolio.dagger.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kr.co.portfolio.dagger.anno.IoDispatcher
import kr.co.portfolio.dagger.remote.RemoteDataSourceImpl
import kr.co.portfolio.dagger.remote.network.NetworkDataSource
import kr.co.portfolio.dagger.remote.network.NetworkDataSourceImpl
import kr.co.portfolio.dagger.repo.RepositoryImpl
import kr.co.portfolio.network.GithubApi

/**
 * Created by kwon on 2020/10/15
 **/
@Module
class RepositoryModule {

    @Provides
    fun provideAppRepository(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        api: GithubApi
    ): RepositoryImpl {
        val userDataSource = RemoteDataSourceImpl(api, ioDispatcher)
        return RepositoryImpl(userDataSource, ioDispatcher)
    }



    @Provides
    fun provideNetworkRepository(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        api: GithubApi
    ): NetworkDataSourceImpl {
        return NetworkDataSourceImpl(api, ioDispatcher)
    }
}