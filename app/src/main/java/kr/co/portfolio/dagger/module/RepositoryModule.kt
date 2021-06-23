package kr.co.portfolio.dagger.module

/**
 * Created by kwon on 2020/10/15
 **/
//@Module
//class RepositoryModule {
//
//    @Provides
//    fun provideAppRepository(
//        @IoDispatcher ioDispatcher: CoroutineDispatcher,
//        api: GithubApi
//    ): RepositoryImpl {
//        val userDataSource = RemoteDataSourceImpl(api, ioDispatcher)
//        return RepositoryImpl(userDataSource, ioDispatcher)
//    }
//
//
//
//    @Provides
//    fun provideNetworkRepository(
//        @IoDispatcher ioDispatcher: CoroutineDispatcher,
//        api: GithubApi
//    ): NetworkDataSourceImpl {
//        return NetworkDataSourceImpl(api, ioDispatcher)
//    }
//
//
//
//    @Provides
//    fun provideItemRepository(
//        @IoDispatcher ioDispatcher: CoroutineDispatcher,
//        api: GithubApi
//    ): ItemDataSourceImpl {
//        return ItemDataSourceImpl(api, ioDispatcher)
//    }
//}