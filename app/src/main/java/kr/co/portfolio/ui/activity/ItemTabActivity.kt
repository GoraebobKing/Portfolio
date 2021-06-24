package kr.co.portfolio.ui.activity

import android.view.MenuItem
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityItemTabBinding
import kr.co.portfolio.ui.fragment.*
import kr.co.portfolio.util.FragmentExtension.hideAndShowFragment
import kr.co.portfolio.viewmodel.ItemViewModel

@AndroidEntryPoint
class ItemTabActivity : BaseActivity<ActivityItemTabBinding, ItemViewModel>(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val itemViewModel : ItemViewModel by viewModels()

    override fun getLayoutResId() = R.layout.activity_item_tab
    override fun getViewModel() = itemViewModel

    private var itemFragment : ItemFragment?= null

    override fun initView() {
        binding.vm = itemViewModel
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