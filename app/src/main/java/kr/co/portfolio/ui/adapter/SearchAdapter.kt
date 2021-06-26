package kr.co.portfolio.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.databinding.AdapterSearchLayerBinding
import kr.co.portfolio.room.RecentlySearch

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){


    private var searchList : MutableList<RecentlySearch> = mutableListOf()
    private var listener : onClicked? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder =
        SearchViewHolder(AdapterSearchLayerBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount() = searchList.count()

    fun setItemList(searchList : MutableList<RecentlySearch>){
        this.searchList = searchList
        //TODO :diff로 변환 예정
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener : onClicked){
        this.listener = listener
    }


    inner class SearchViewHolder(private val _binding : AdapterSearchLayerBinding) : RecyclerView.ViewHolder(_binding.root) {

        fun bind(response : RecentlySearch){
            _binding.root.setOnClickListener{
                listener?.onClick(response)
            }
        }
    }

    interface onClicked {
        fun onClick(item : RecentlySearch)
    }
}