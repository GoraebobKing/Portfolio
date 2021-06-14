package kr.co.portfolio.network.module

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by kwon on 2021/05/27
 **/
abstract class CallNetworkResponse<T, U>(
    protected val network : Call<T>
) : Call<U> {

    override fun execute(): Response<U> = throw NotImplementedError()
    override fun enqueue(callback: Callback<U>) = enqueueImpl(callback)
    override fun clone(): Call<U>  = cloneImpl()

    override fun cancel() { network.cancel() }
    override fun request(): Request = network.request()
    override fun isExecuted() = network.isExecuted
    override fun isCanceled() = network.isCanceled

    override fun timeout() = Timeout.NONE

    abstract fun enqueueImpl(call : Callback<U>)
    abstract fun cloneImpl() : Call<U>
}