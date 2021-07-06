package kr.co.portfolio.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.preferences.AccountManager
import kr.co.portfolio.repository.ItemRepository
import kr.co.portfolio.room.RecentlySearch
import kr.co.portfolio.util.Const
import kr.co.portfolio.util.Logger
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repo : ItemRepository, private val account : AccountManager): BaseViewModel() {

    var searchLiveData = MutableLiveData<Pair<String, MutableList<RecentlySearch>>>()
    var itemLiveData = MutableLiveData<MutableList<ProductResponse>>()

    private var itemAllList : MutableList<ProductResponse>? = null

    override fun onCleared() {
        //viewModelScope를 사용하면 자동으로 취소시켜줌
//        responseJob.cancel()
        super.onCleared()
    }

    init {
        getItemViewList()
    }

    private fun getItemViewList(){
        viewModelScope.launch(responseJob) {
            repo.getItemList(
                onStart = {
                    isLoadingData.postValue(true)
                },
                onError = {code, message ->
                    errorLaunch = {
                        getItemViewList()
                    }
                    errorResponse.postValue(Pair(BaseExceptionNavigator.NETWORK_ERROR, message?:"통신오류"))
                },
                onComplete = {
                    isLoadingData.postValue(false)
                },
                onResult = {
                    isLoadingData.postValue(false)
                    itemLiveData.postValue(it)
                    itemAllList = it
                }
            )
        }
    }

    /**
     * 검색완료
     * **/
    fun setSearchItem(str : String){
        viewModelScope.launch(databaseJob) {

            if(str.trim() == ""){
                itemAllList?.let {
                    itemLiveData.postValue(it)
                }
            } else {
                val searchList = mutableListOf<ProductResponse>()
                itemLiveData.value?.forEach {

                    if(it.title?.contains(str, ignoreCase = true) == true){
                        searchList.add(it)
                    }

                    if(searchList.count() > 0){
                        if(account.getBoolean(Const.SAVE_SEARCH_YN)){
                            repo.insertSearchData(str)
                        }
                        itemLiveData.postValue(searchList)
                    }
                }
            }
        }
    }

    /**
     * 검색시마다
     * **/
    fun getSearchList(str : String){
        viewModelScope.launch(databaseJob) {

            val searchList = mutableListOf<RecentlySearch>()
            itemAllList?.forEach {
                if(it.title?.contains(str, ignoreCase = true) == true){
                    it.title?.let { productNm ->
                        searchList.add(RecentlySearch(productNm))
                    }
                }
            }

            //데이터가잇을경우 보여주고 없을경우 팝업
            Logger.e("검색된 데이터 사이즈 : ${searchList.count()}")
            searchLiveData.postValue(Pair(str, searchList.toMutableList()))
//            if(searchList.count() > 0){
//
//            } else {
//
//            }
        }
    }

    fun clearSaveData(){
        viewModelScope.launch(databaseJob) {
            repo.clearAll()
        }
    }

    fun favoriteOption(item : ProductResponse){
        viewModelScope.launch(databaseJob) {
            if(item.checked){
                repo.favoriteAdd(item)
            } else {
                repo.favoriteRemove(item)
            }
        }
    }
}