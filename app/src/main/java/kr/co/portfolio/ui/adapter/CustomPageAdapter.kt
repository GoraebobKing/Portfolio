package kr.co.portfolio.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import kr.co.portfolio.R
import kr.co.portfolio.data.PagerData
import kr.co.portfolio.databinding.LayerPagerAdapterBinding
import java.util.logging.Logger

/**
 * Created by kwon on 2020/10/29
 **/
class CustomPageAdapter constructor(private val count : Int) : PagerAdapter() {

    private var dataList : MutableList<PagerData> = ArrayList()

    override fun getCount() = Int.MAX_VALUE

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val index = if(count > position){
            position
        } else {
            position % count
        }

        Log.e("dataList", "index : $index position : $position data : ${dataList[index].name}")

        val data = dataList[index]
        val mLayoutInflater =  container.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.layer_pager_adapter, container, false) as LayerPagerAdapterBinding

        binding.tvName.text = data.name
        binding.cvBackground.setBackgroundColor(data.color)

        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    fun updateData(dataList : MutableList<PagerData>){
        this.dataList = dataList
        notifyDataSetChanged()
    }
}