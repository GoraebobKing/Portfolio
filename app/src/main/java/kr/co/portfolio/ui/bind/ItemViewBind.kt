package kr.co.portfolio.ui.bind

import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.ui.adapter.ItemAdapter
import kr.co.portfolio.ui.custom.CustomItemDecoration
import kr.co.portfolio.ui.fragment.ItemFragment
import kr.co.portfolio.util.Common.toPx

object ItemViewBind {

//    @JvmStatic
//    @BindingAdapter(value =[
//        "view",
//        "recycler"
//    ])
//    fun recyclerSetting(
//        view : ConstraintLayout,
//        fragment : ItemFragment,
//        recyclerView: RecyclerView
//    ){
//        fragment.context?.let {
//            recyclerView.addItemDecoration(
//                CustomItemDecoration(1.toPx(it), Color.parseColor("#ebebeb"),0,0))
//        }
//    }

    @JvmStatic
    @BindingAdapter(
        "view",
        "item")
    fun itemDataSetting(
        view : RecyclerView,
        fragment : ItemFragment,
        item : MutableList<ProductResponse>?
    ){

        fragment.context?.let {
            view.adapter?.let {adapter ->
                item?.let {
                    if(adapter is ItemAdapter){
                        adapter.setItemList(it)
                    }
                }
            }?: run {
                ItemAdapter().run {
                    view.adapter = this
                    view.addItemDecoration(CustomItemDecoration(1.toPx(it), Color.parseColor("#ebebeb"),0,0))
                }
            }
        }

    }
}