package kr.co.portfolio.dagger.module

import android.content.Context
import android.util.Log
import dagger.Module
import dagger.Provides
import kr.co.portfolio.BuildConfig
import kr.co.portfolio.network.GithubApi
import kr.co.portfolio.network.module.CallNetworkFactory
import okhttp3.Interceptor
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
//            .baseUrl(BuildConfig.BASE_URL)
////            .baseUrl("https://api.github.com/")
//            .baseUrl("https://1ec3b1b2-53d5-4a40-b0c7-452870a2e360.mock.pstmn.io")
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(factory)
            .addCallAdapterFactory(CallNetworkFactory())
            .client(okHttpClient)
            .build()
            .create(GithubApi::class.java)
    }



    @Provides
    fun provideOkhttpClient(interceptor: HttpLoggingInterceptor, headerInterceptor : Interceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor() : Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("deviceType", "android")
                .build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideConverterFactory() : Converter.Factory {
        return GsonConverterFactory.create()
    }

}