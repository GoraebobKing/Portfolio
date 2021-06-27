package kr.co.portfolio.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.portfolio.network.GithubApi
import kr.co.portfolio.network.module.CallNetworkFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by kwon on 2021/06/23
 **/

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideGithubApi(okHttpClient: OkHttpClient, factory : Converter.Factory) : GithubApi {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(factory)
            .addCallAdapterFactory(CallNetworkFactory())
            .client(okHttpClient)
            .build()
            .create(GithubApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor, headerInterceptor : Interceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(interceptor)
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideHeaderInterceptor() : Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("deviceType", "android")
                .build()
            chain.proceed(request)
        }
    }

    @Singleton
    @Provides
    fun provideConverterFactory() : Converter.Factory {
        return GsonConverterFactory.create()
    }
}