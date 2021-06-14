package kr.co.portfolio.network.module

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * Created by kwon on 2021/05/27
 **/
class CallNetworkAdapter constructor(
    private val responseType : Type
) : CallAdapter<Type, Call<NetworkResponse<Type>>> {

    override fun responseType(): Type {
        return responseType
    }

    override fun adapt(call: Call<Type>): Call<NetworkResponse<Type>> {
        return RetroCallback(call)
    }
}