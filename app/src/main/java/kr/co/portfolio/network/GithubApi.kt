package kr.co.portfolio.network

import kr.co.portfolio.data.User
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by kwon on 2020/10/13
 **/
interface GithubApi {

    @GET("users")
    fun getUsers() : Call<List<User>>
}