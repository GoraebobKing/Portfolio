package kr.co.portfolio.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.data.PagerData
import kr.co.portfolio.databinding.LayerPagerAdapterBinding

/**
 * Created by kwon on 2020/10/29
 **/
class Pager2Adapter : RecyclerView.Adapter<Pager2Adapter.Pager2Holder>() {

    private var dataList : MutableList<PagerData> = ArrayList()
    private var listener : ClickEvent? = null

    fun updateData(dataList : MutableList<PagerData>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    fun setOnCliked(listener : ClickEvent){
        this.listener = listener
    }

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Pager2Holder(LayerPagerAdapterBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Pager2Holder, position: Int) {

        val result = dataList[position]
        with(holder.binding){
            tvName.text = result.name
            cvBackground.setBackgroundColor(result.color)
        }

        holder.itemView.setOnClickListener {
            listener?.onClicked()
        }
    }

    inner class Pager2Holder(val binding: LayerPagerAdapterBinding) : RecyclerView.ViewHolder(binding.root) { }

    interface ClickEvent{
        fun onClicked()
    }
}