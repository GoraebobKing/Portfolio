package kr.co.portfolio.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by kwon on 2021/06/29
 **/
class ItemPageAdapter constructor(fa : FragmentActivity) : FragmentStateAdapter(fa) {

    private var fragments = ArrayList<Fragment>()

    override fun getItemCount() = fragments.count()

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment){
        fragments.add(fragment)
        notifyItemInserted(fragments.count()-1)
    }

    fun removeFragment(fragment : Fragment){
        fragments.removeLast()
        notifyItemRemoved(fragments.count())
    }
}