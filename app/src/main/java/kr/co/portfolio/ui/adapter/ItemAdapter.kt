package kr.co.portfolio.ui.adapter

import android.content.Context
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import kr.co.portfolio.data.ProductResponse
import kr.co.portfolio.databinding.AdapterItemBinding
import kr.co.portfolio.util.Logger

/**
 * Created by kwon on 2021/06/24
 **/
class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(),
    ListPreloader.PreloadModelProvider<ProductResponse>{

    private var context : Context? = null
    private var itemList : MutableList<ProductResponse> = mutableListOf()

    private var listener : onClicked? = null

    private var mLastClickTime : Long = 0

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

    fun setOnClicked(listener : onClicked){
        this.listener = listener
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
                if(SystemClock.elapsedRealtime() - mLastClickTime > 1000){
                    val pos = adapterPosition
                    if ( pos != RecyclerView.NO_POSITION){
                        listener?.itemClick(_binding.ivItemThumbNail, item)
                    }
                }
            }
            _binding.chkProduct.setOnClickListener {
                item.checked = _binding.chkProduct.isChecked
                Logger.e("클릭 이벤트 ${_binding.chkProduct.isChecked}")
                listener?.itemFavorite(item)
            }
        }
    }

    interface onClicked {
        fun itemClick(view: View, item: ProductResponse)
        fun itemFavorite(item: ProductResponse)
    }
}