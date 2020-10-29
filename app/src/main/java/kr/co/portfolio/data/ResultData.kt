package kr.co.portfolio.data

import java.lang.Exception

/**
 * Created by kwon on 2020/10/15
 **/
sealed class ResultData<out T : Any> {
    data class Success<out T : Any>(val data : T) : ResultData<T>()
    data class Error<out T : Any>(val data : T, val exception : String) : ResultData<T>()
}