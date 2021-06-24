package kr.co.portfolio.repository

import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.network.GithubApi
import kr.co.portfolio.network.module.NetworkResponse
import javax.inject.Inject

/**
 * Created by kwon on 2021/06/23
 **/
class ItemRepository @Inject constructor(
    private val api: GithubApi,
) {

    suspend fun getItemList(
        onStart : () -> Unit,
        onError : (code : Int, message : String?) -> Unit,
        onComplete : (arr : ArrayList<ProductResponse>) -> Unit
    ){

        when(val result = api.getProductList()){

            is NetworkResponse.Success -> {
                if(result.body.isNullOrEmpty()){
                    onError(result.statusCode, "데이터가 없습니다.")
                } else {
                    onComplete(result.body)
                }
            }

            is NetworkResponse.Error -> {
                onError(result.statusCode, result.message)
            }
        }

    }
}