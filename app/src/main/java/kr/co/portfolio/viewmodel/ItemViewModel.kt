package kr.co.portfolio.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.repository.ItemRepository
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repo : ItemRepository): BaseViewModel() {

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

}