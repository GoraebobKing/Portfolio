package kr.co.portfolio.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kr.co.portfolio.network.GithubApi
import kr.co.portfolio.repository.ItemRepository
import kr.co.portfolio.room.ProductResponseDao
import kr.co.portfolio.room.RecentlySearchDao

/**
 * Created by kwon on 2021/06/23
 **/
@InstallIn(ViewModelComponent::class)
@Module
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providerItemRepository(
        api : GithubApi,
        dataDao : RecentlySearchDao,
        productDao : ProductResponseDao) : ItemRepository = ItemRepository(api, dataDao, productDao)
}