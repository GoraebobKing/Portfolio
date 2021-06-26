package kr.co.portfolio.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.databinding.AdapterItemBinding

/**
 * Created by kwon on 2021/06/24
 **/
class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(), ListPreloader.PreloadModelProvider<ProductResponse> {

    private var context : Context? = null
    private var itemList : MutableList<ProductResponse> = mutableListOf()

    init {
        setHasStableIds(false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ItemViewHolder{
        context = parent.context
        return ItemViewHolder(
            parent.context, AdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.count()

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun setItemList(item : MutableList<ProductResponse>){
        itemList = item
        notifyDataSetChanged()
    }

    override fun getPreloadItems(position: Int): MutableList<ProductResponse> {
        return itemList.subList(position, position+1)
    }

    override fun getPreloadRequestBuilder(item: ProductResponse): RequestBuilder<*>? {

        return if(context == null){
            null
        } else {
            Glide.with(context!!).load(item.image).override(300, 300)
        }
    }

    inner class ItemViewHolder(context : Context, private val _binding : AdapterItemBinding) : RecyclerView.ViewHolder(_binding.root){
        fun bind(item : ProductResponse){
            _binding.item = item
            _binding.root.setOnClickListener {
                item.checked = !item.checked
            }
        }
    }
}