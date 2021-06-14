package kr.co.portfolio.network.module

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by kwon on 2021/06/12
 **/
class RetroCallback<T>(network : Call<T>) : CallNetworkResponse<T, NetworkResponse<T>>(network) {

    override fun enqueueImpl(returnCall: Callback<NetworkResponse<T>>) {
        network.enqueue(object : Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {

                if(response.isSuccessful){
                    val result = response.body().toString()
                    returnCall.onResponse(this@RetroCallback, Response.success(NetworkResponse.Success(response, result)))
                } else {
                    returnCall.onResponse(this@RetroCallback, Response.success(NetworkResponse.Error(response.code(), response.message())))
                }

            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                returnCall.onResponse(this@RetroCallback, Response.success(NetworkResponse.Error(500, t.localizedMessage?:"")))
            }
        })
    }

    override fun cloneImpl(): Call<NetworkResponse<T>> {
        TODO("Not yet implemented")
    }
}