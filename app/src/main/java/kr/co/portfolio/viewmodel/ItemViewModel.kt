package kr.co.portfolio.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.repository.ItemRepository
import kr.co.portfolio.room.RecentlySearch
import kr.co.portfolio.util.Logger
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repo : ItemRepository): BaseViewModel() {

    var searchLiveData = MutableLiveData<MutableList<RecentlySearch>>()
    var itemLiveData = MutableLiveData<MutableList<ProductResponse>>()

    override fun onCleared() {
        responseJob.cancel()
        super.onCleared()
    }

    init {
        getItemViewList()
    }

    private fun getItemViewList(){
        viewModelScope.launch(responseJob) {
            repo.getItemList(
                onStart = {},
                onError = {code, message ->
                    errorLaunch = {
                        getItemViewList()
                    }
                    errorResponse.postValue(Pair(BaseExceptionNavigator.NETWORK_ERROR, message?:"통신오류"))
                },
                onComplete = {
                    itemLiveData.postValue(it)
                }
            )
        }
    }

    fun setSearchItem(str : String){
        viewModelScope.launch(responseJob) {
            repo.insertSearchData(str)
        }
    }

    fun getSearchList(){
        viewModelScope.launch(responseJob) {
            searchLiveData.postValue(repo.getSearchList().toMutableList())
        }
    }
}