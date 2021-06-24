package kr.co.portfolio.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.databinding.AdapterItemBinding

/**
 * Created by kwon on 2021/06/24
 **/
class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var itemList : MutableList<ProductResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ItemViewHolder = ItemViewHolder(
        parent.context, AdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.count()

    fun setItemList(item : MutableList<ProductResponse>){
        itemList = item
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(context : Context, private val _binding : AdapterItemBinding) : RecyclerView.ViewHolder(_binding.root){
        fun bind(item : ProductResponse){
            _binding.item = item
            _binding.root.setOnClickListener {

            }
        }
    }
}