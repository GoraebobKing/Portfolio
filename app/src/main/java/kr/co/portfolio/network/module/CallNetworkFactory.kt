package kr.co.portfolio.network.module

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by kwon on 2021/05/27
 **/
class CallNetworkFactory() : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ) = when (getRawType(returnType)){
        Call::class.java -> {
            val callType = getParameterUpperBound(0, returnType as ParameterizedType)
            when (getRawType(callType)) {

                NetworkResponse::class.java -> {
                    val resultType = getParameterUpperBound(0, callType as ParameterizedType)
                    CallNetworkAdapter(resultType)
                }
                else -> null
            }
        }

        else -> {
            null
        }
    }
}