package kr.co.portfolio.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.portfolio.room.DataBaseModule
import kr.co.portfolio.room.ProductResponseDao
import kr.co.portfolio.room.RecentlySearchDao
import javax.inject.Singleton

/**
 * Created by kwon on 2021/06/24
 **/
@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Provides
    fun provideDatabaseModule(@ApplicationContext context: Context): DataBaseModule {
        return Room.databaseBuilder(context.applicationContext, DataBaseModule::class.java, "item.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRecentlySearchDao(dao: DataBaseModule): RecentlySearchDao {
        return dao.todoDao()
    }

    @Singleton
    @Provides
    fun provideProductDao(dao: DataBaseModule): ProductResponseDao {
        return dao.todoProductDao()
    }


}



