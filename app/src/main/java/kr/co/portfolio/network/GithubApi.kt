package kr.co.portfolio.network

import kr.co.portfolio.const.URLs
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.data.User
import kr.co.portfolio.network.module.NetworkResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by kwon on 2020/10/13
 **/
interface GithubApi {

    @GET("/products")
    suspend fun getProductList() : NetworkResponse<ArrayList<ProductResponse>>




    @GET("users")
    fun getUsers() : Call<List<User>>

    @GET("users")
    suspend fun getCoroutineUsers() : Response<List<User>>

    @GET("users")
    suspend fun getRepoUsers() : List<User>

    @POST(URLs.introCheck)
    suspend fun versionCheck(
        @Body map : HashMap<String, Any>) : NetworkResponse<String>
}