package kr.co.portfolio.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.databinding.LayerSpinnerItemBinding

/**
 * Created by kwon on 2020/09/23
 **/
class SpinnerAdapter : RecyclerView.Adapter<SpinnerAdapter.SpinnerAdapterHolder>(){

    private lateinit var itemList : MutableList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SpinnerAdapterHolder(LayerSpinnerItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = if(::itemList.isInitialized) itemList.size else 0

    fun updateItem(itemList : MutableList<String>){
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SpinnerAdapterHolder, position: Int) {
        holder.binding.tvItem.text = itemList[position]
    }

    inner class SpinnerAdapterHolder constructor(val binding : LayerSpinnerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}