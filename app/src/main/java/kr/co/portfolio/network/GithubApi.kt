package kr.co.portfolio.network

import kr.co.portfolio.data.ResultData
import kr.co.portfolio.data.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by kwon on 2020/10/13
 **/
interface GithubApi {

    @GET("users")
    fun getUsers() : Call<List<User>>

    @GET("users")
    suspend fun getCoroutineUsers() : Response<List<User>>

    @GET("users")
    suspend fun getRepoUsers() : List<User>
}