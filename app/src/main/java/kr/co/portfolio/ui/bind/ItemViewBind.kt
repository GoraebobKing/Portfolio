package kr.co.portfolio.ui.bind

import android.graphics.Color
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.R
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.room.RecentlySearch
import kr.co.portfolio.ui.activity.ItemTabActivity
import kr.co.portfolio.ui.adapter.ItemAdapter
import kr.co.portfolio.ui.adapter.SearchAdapter
import kr.co.portfolio.ui.custom.CustomItemDecoration
import kr.co.portfolio.ui.custom.MaxHeightRecyclerView
import kr.co.portfolio.ui.fragment.ItemFragment
import kr.co.portfolio.util.Common.toPx
import kr.co.portfolio.util.Logger
import kr.co.portfolio.viewmodel.ItemViewModel

object ItemViewBind {


    @JvmStatic
    @BindingAdapter(
        "activity",
        "viewModel",
        "item"
    )
    fun activitySearchItemDataSetting(
        view : MaxHeightRecyclerView,
        activity : ItemTabActivity,
        viewModel : ItemViewModel,
        item : Pair<String, MutableList<RecentlySearch>>?
    ){
        view.adapter?.let {adapter ->
            item?.let {
                if(adapter is SearchAdapter){
                    adapter.setItemList(it.first, it.second)
                }
            }
        }?: run {
            SearchAdapter().run {
                view.adapter = this
                view.addItemDecoration(CustomItemDecoration(1.toPx(activity), Color.parseColor("#ebebeb"),0,0))
                view.setOnClickListener{
                }
            }
        }
    }


    @JvmStatic
    @BindingAdapter(
        "itemView",
        "itemModel",
        "itemData")
    fun fragmentItemDataSetting(
        view : RecyclerView,
        fragment : ItemFragment,
        model : ItemViewModel,
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
                    setOnClicked(object : ItemAdapter.onClicked{
                        override fun itemClick(view: View, item: ProductResponse) {
                            (fragment.requireActivity() as ItemTabActivity).goToItemDetailActivity(view, item)
                        }

                        override fun itemFavorite(item: ProductResponse) {
                            model.favoriteOption(item)
                        }
                    })
                }
            }
        }

    }
}