package kr.co.portfolio.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.portfolio.network.GithubApi
import kr.co.portfolio.repository.ItemRepository
import kr.co.portfolio.room.RecentlySearchDao
import javax.inject.Singleton

/**
 * Created by kwon on 2021/06/23
 **/
@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providerItemRepository(api : GithubApi, dataDao : RecentlySearchDao) : ItemRepository = ItemRepository(api, dataDao)
}