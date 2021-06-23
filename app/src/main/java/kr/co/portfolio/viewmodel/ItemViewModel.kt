package kr.co.portfolio.viewmodel


import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//class ItemViewModel @Inject constructor(private val itemImpl: ItemDataSourceImpl) : BaseViewModel() {
//
//    enum class ItemNavigator {
//        NETWORK_FAIL, ITEM_SUCCESS
//    }
//
//    var networkLiveData = MutableLiveData<Pair<ItemNavigator, String>>()
//
//    var itemLiveData : MutableLiveData<MutableList<Product>> = MutableLiveData()
//
//    private var test = "asdasdasd"
//
//    init {
//        viewModelScope.launch {
//            itemImpl.productList(
//                onStart = {},
//                onError = {code, message ->
//                    networkLiveData.postValue(Pair(ItemNavigator.NETWORK_FAIL, message?:""))
//                },
//                onComplete = { result ->
//                    itemLiveData.postValue(result.toMutableList())
//                }
//            )
//        }
//    }
//
//    fun test111(){
//        test = "지랄하네"
//    }
//
//    fun test(){
//        Logger.e("텟스트 : $test")
//    }
//}

@HiltViewModel
class ItemViewModel @Inject constructor(): BaseViewModel() {

}