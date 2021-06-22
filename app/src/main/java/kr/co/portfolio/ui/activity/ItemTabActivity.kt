package kr.co.portfolio.ui.activity

import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityItemTabBinding
import kr.co.portfolio.ui.fragment.*
import kr.co.portfolio.util.FragmentExtension.hideAndShowFragment
import kr.co.portfolio.viewmodel.ItemViewModel

class ItemTabActivity : BaseActivity<ActivityItemTabBinding, ItemViewModel>(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun getLayoutResId() = R.layout.activity_item_tab
    override fun getModelId() = ItemViewModel::class.java

    private var itemFragment : ItemFragment?= null

    override fun initView() {
        binding.bottomNavi.setOnNavigationItemSelectedListener(this@ItemTabActivity)
        binding.bottomNavi.selectedItemId = R.id.menu_item_1
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_1 -> {

                if (itemFragment == null) {
                    itemFragment = ItemFragment()
                }

                itemFragment?.let {
                    hideAndShowFragment(it)
                }

                return true
            }



        }
        return false
    }
}