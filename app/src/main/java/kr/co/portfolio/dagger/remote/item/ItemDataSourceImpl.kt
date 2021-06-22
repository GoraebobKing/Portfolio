package kr.co.portfolio.dagger.remote.item

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kr.co.portfolio.dagger.anno.IoDispatcher
import kr.co.portfolio.data.Product
import kr.co.portfolio.network.GithubApi
import kr.co.portfolio.network.module.NetworkResponse
import kr.co.portfolio.util.Logger


/**
 * Created by kwon on 2021/06/10
 **/
class ItemDataSourceImpl constructor(
    private val service: GithubApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher) : ItemDataSource {

    override suspend fun productList(
        onStart : () -> Unit,
        onError : (code : Int, message : String?) -> Unit,
        onComplete : (array: Array<Product>) -> Unit
    ) {
        onStart()

        withContext(ioDispatcher){

            when(val result = service.getProductList()){

                is NetworkResponse.Success -> {
                    Logger.e("Network Success : $result")
                    result.body?.let{
                        onComplete(it)
                    }
                }

                is NetworkResponse.Error -> {
                    Logger.e("Network Error : $result")
                    onError(result.statusCode, result.message)
                }
            }
        }
    }



    //    override suspend fun getRepoUsers() : ResultData<List<User>> =
//        withContext(ioDispatcher) {ResultData.Success(service.getRepoUsers()) }







    


}