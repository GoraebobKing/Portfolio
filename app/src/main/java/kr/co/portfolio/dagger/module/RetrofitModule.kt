package kr.co.portfolio.dagger.module

import android.content.Context
import android.util.Log
import dagger.Module
import dagger.Provides
import kr.co.portfolio.network.GithubApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by kwon on 2020/10/13
 * Retrofit을 사용하기 위해서 만든 모듈
 * 기본적으로 Provides 어노테이션을 사용하면 함수명 앞이 provide가 붙고 클래스 단위가 들어가는거 같음
 **/
@Module
class RetrofitModule {

    @Provides
    fun provideGithubApi(context: Context, okHttpClient: OkHttpClient, factory : Converter.Factory) : GithubApi {
        Log.e("provideGithubApi","co $context")
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(factory)
            .client(okHttpClient)
            .build()
            .create(GithubApi::class.java)
    }

    @Provides
    fun provideOkhttpClient(interceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideConverterFactory() : Converter.Factory {
        return GsonConverterFactory.create()
    }

}