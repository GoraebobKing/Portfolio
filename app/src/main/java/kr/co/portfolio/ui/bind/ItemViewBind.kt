package kr.co.portfolio.ui.bind

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.data.Product

object ItemViewBind {

    @JvmStatic
    @BindingAdapter(
        "item")
    fun itemDataSetting(
        view : RecyclerView,
        item : MutableList<Product>
    ){

        item?.let{

        }
    }
}