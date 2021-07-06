package kr.co.portfolio.repository

import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.network.GithubApi
import kr.co.portfolio.network.module.NetworkResponse
import kr.co.portfolio.preferences.AccountManager
import kr.co.portfolio.room.ProductResponseDao
import kr.co.portfolio.room.RecentlySearch
import kr.co.portfolio.room.RecentlySearchDao

/**
 * Created by kwon on 2021/06/23
 **/
class ItemRepository constructor(
    private val api: GithubApi,
    private val dataDao : RecentlySearchDao,
    private val productDao : ProductResponseDao
) {

    suspend fun getItemList(
        onStart : () -> Unit,
        onError : (code : Int, message : String?) -> Unit,
        onComplete : () -> Unit,
        onResult : (arr : ArrayList<ProductResponse>) -> Unit,
    ){
        onStart()
        when(val result = api.getProductList()){

            is NetworkResponse.Success -> {
                if(result.body.isNullOrEmpty()){
                    onError(result.statusCode, "데이터가 없습니다.")
                } else {

                    val favoriteIndexList = productDao.getFavoriteIdList()

                    if(favoriteIndexList.count() > 0){
                        result.body.forEachIndexed { _, it ->
                            favoriteIndexList.forEach { index ->
                                if(index == it.id){
                                    it.checked = true
                                    return@forEach
                                }
                            }
                        }
                    }

                    onResult(result.body)
                }
            }

            is NetworkResponse.Error -> {
                onError(result.statusCode, result.message)
            }
        }

        onComplete()
    }

    suspend fun insertSearchData(str : String){
        dataDao.inert(RecentlySearch(str))
    }

    suspend fun getSearchList() : List<RecentlySearch>{
        return dataDao.getSearchList()
    }

    suspend fun getSearch(str : String) : List<RecentlySearch>{
        return dataDao.getSearch(str)
    }

    suspend fun clearAll(){
         dataDao.clearAll()
    }

    suspend fun favoriteAdd(item : ProductResponse){
        productDao.inert(item)
    }

    suspend fun favoriteRemove(item : ProductResponse){
        productDao.delete(item)
    }
}