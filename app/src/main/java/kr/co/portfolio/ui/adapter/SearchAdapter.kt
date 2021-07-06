package kr.co.portfolio.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.R
import kr.co.portfolio.databinding.AdapterSearchLayerBinding
import kr.co.portfolio.room.RecentlySearch
import kr.co.portfolio.util.Common.getSectionOfTextColor

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){


    private var searchList : MutableList<RecentlySearch> = mutableListOf()
    private var listener : onClicked? = null

    private var searchLabel = ""


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder =
        SearchViewHolder(parent.context, AdapterSearchLayerBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount() = searchList.count()

    fun setItemList(str : String, searchList : MutableList<RecentlySearch>){
        this.searchLabel = str
        this.searchList = searchList
        notifyDataSetChanged()
    }

    fun setClearList(){
        searchLabel = ""
        this.searchList = mutableListOf()
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener : onClicked){
        this.listener = listener
    }


    inner class SearchViewHolder(private val context : Context, private val _binding : AdapterSearchLayerBinding) : RecyclerView.ViewHolder(_binding.root) {

        fun bind(response : RecentlySearch){
            _binding.tvSearchLabel.text = response.search.getSectionOfTextColor(context, R.color.c5b83f3, response.search, searchLabel)

            _binding.root.setOnClickListener{
                listener?.onClick(response)
            }
        }
    }

    interface onClicked {
        fun onClick(item : RecentlySearch)
    }
}