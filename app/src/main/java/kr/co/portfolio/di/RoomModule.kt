package kr.co.portfolio.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.portfolio.room.DataBaseModule
import kr.co.portfolio.room.RecentlySearchDao
import javax.inject.Singleton

/**
 * Created by kwon on 2021/06/24
 **/
@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext application: Application): DataBaseModule {
        return Room.databaseBuilder(application, DataBaseModule::class.java, "item")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDatabaseDao(dao: DataBaseModule): RecentlySearchDao {
        return dao.todoDao()
    }


}



