package kr.co.portfolio.dagger.remote.item


import kr.co.portfolio.data.Product
import kr.co.portfolio.network.module.NetworkResponse

/**
 * Created by kwon on 2021/06/10
 **/
interface ItemDataSource {
    suspend fun productList(
        onStart : () -> Unit,
        onError : (code : Int, message : String?) -> Unit,
        onComplete : (array: Array<Product>) -> Unit)
//    suspend fun versionCheck() : NetworkResponse<String>
}