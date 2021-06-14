package kr.co.portfolio.network.module

import okhttp3.Headers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by kwon on 2021/06/01
 **/
sealed class NetworkResponse<out T> {
    data class Success<T>(val response: Response<T>, val result: String? = null) : NetworkResponse<T>(){
        val statusCode: Int = response.code()
        val headers: Headers = response.headers()
        val raw: okhttp3.Response = response.raw()
        val body: T? = response.body()
    }

    data class Error<T>(val statusCode: Int, val message : String?) : NetworkResponse<T>()
}
