package kr.co.portfolio.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.co.portfolio.dagger.remote.item.ItemDataSourceImpl
import kr.co.portfolio.data.Product
import javax.inject.Inject

class ItemViewModel @Inject constructor(private val itemImpl: ItemDataSourceImpl) : BaseViewModel() {

    enum class ItemNavigator {
        NETWORK_FAIL, ITEM_SUCCESS
    }

    var networkLiveData = MutableLiveData<Pair<ItemNavigator, String>>()

    var itemLiveData : MutableLiveData<MutableList<Product>> = MutableLiveData()

    init {
        viewModelScope.launch {
            itemImpl.productList(
                onStart = {},
                onError = {code, message ->
                    networkLiveData.postValue(Pair(ItemNavigator.NETWORK_FAIL, message?:""))
                },
                onComplete = { result ->
                    itemLiveData.postValue(result.toMutableList())
                }
            )
        }
    }
}