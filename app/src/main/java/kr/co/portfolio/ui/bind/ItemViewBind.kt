package kr.co.portfolio.ui.bind

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.ui.adapter.ItemAdapter

object ItemViewBind {

    @JvmStatic
    @BindingAdapter(
        "item")
    fun itemDataSetting(
        view : RecyclerView,
        item : MutableList<ProductResponse>?
    ){

        view.adapter?.let {adapter ->
            item?.let {
                if(adapter is ItemAdapter){
                    adapter.setItemList(it)
                }
            }
        }?: run {
            ItemAdapter().run {
                view.adapter = this
            }
        }

    }
}