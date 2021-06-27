package kr.co.portfolio.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.portfolio.R
import kr.co.portfolio.preferences.AccountManager
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AccountModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context : Context) = AccountManager(context)
}