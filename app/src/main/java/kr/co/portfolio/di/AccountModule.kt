package kr.co.portfolio.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.portfolio.R
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AccountModule {


//    @Singleton
//    @Provides
//    fun provideSharedPreferences(@ApplicationContext context : Context) =
//        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
}