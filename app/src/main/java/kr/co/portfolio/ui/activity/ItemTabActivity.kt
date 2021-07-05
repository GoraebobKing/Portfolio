package kr.co.portfolio.ui.activity

import android.app.SearchManager
import android.content.Context
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityItemTabBinding
import kr.co.portfolio.preferences.AccountManager
import kr.co.portfolio.ui.adapter.ItemPageAdapter
import kr.co.portfolio.ui.adapter.SearchAdapter
import kr.co.portfolio.ui.fragment.*
import kr.co.portfolio.util.Const
import kr.co.portfolio.util.FragmentExtension.hideAndShowFragment
import kr.co.portfolio.util.Logger
import kr.co.portfolio.util.gone
import kr.co.portfolio.util.visible
import kr.co.portfolio.viewmodel.ItemViewModel
import javax.inject.Inject


@AndroidEntryPoint
class ItemTabActivity : BaseActivity<ActivityItemTabBinding, ItemViewModel>(),
    BottomNavigationView.OnNavigationItemSelectedListener, Toolbar.OnMenuItemClickListener{

    private val itemViewModel : ItemViewModel by viewModels()

    @Inject
    lateinit var account : AccountManager

    override fun getLayoutResId() = R.layout.activity_item_tab
    override fun getViewModel() = itemViewModel

    private var itemFragment : ItemFragment?= null
    private var favoriteFragment : FavoriteFragment?= null
    private var nearbyFragment : NearbyFragment?= null

    private var searchView : SearchView? = null

    private lateinit var itemAdapter : ItemPageAdapter

    override fun initView() {
        binding.view = this
        binding.vm = itemViewModel

        itemAdapter = ItemPageAdapter(this)

        itemFragment = ItemFragment().apply {
            itemAdapter.addFragment(this)
        }

        favoriteFragment = FavoriteFragment().apply {
                itemAdapter.addFragment(this)
        }

        nearbyFragment = NearbyFragment().apply {
            itemAdapter.addFragment(this)
        }

        binding.pagerLayer.adapter = itemAdapter
        setSupportActionBar(binding.toolbar)

        binding.bottomNavi.setOnNavigationItemSelectedListener(this@ItemTabActivity)
        binding.bottomNavi.selectedItemId = R.id.menu_item_1

        binding.toolbar.setOnMenuItemClickListener(this@ItemTabActivity)

        binding.pagerLayer.offscreenPageLimit = 3
        binding.pagerLayer.registerOnPageChangeCallback(pagerCallback)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Logger.e("onCreateOptionsMenu")
        menuInflater.inflate(R.menu.menu_toolbar, menu)

        menu.findItem(R.id.tool_item_2).title = saveSearchLabelChange()

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.tool_item_3).actionView as SearchView).apply{

            searchView = this

            this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
//                    Logger.e("Query $query")
                    query?.let {
                        itemViewModel.setSearchItem(it)
                    }
                    clearFocus()
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    Logger.e("Query $newText")
                    if(account.getBoolean(Const.SAVE_SEARCH_YN)){
                        newText?.let{ str ->
                            itemViewModel.getSearchList(str)
                        }
                    }
                    return false
                }
            })

            this.setOnQueryTextFocusChangeListener { _, hasFocus ->
                Logger.e("SearchView hasFocus : $hasFocus")
                if(hasFocus){
                    binding.rvSearch.visible()
                } else {
                    binding.rvSearch.gone()
                }
            }

            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        return true
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.tool_item_1 -> {
                Logger.e("저장 삭제")
                itemViewModel.clearSaveData()
                binding.rvSearch.adapter?.let {adapter ->
                    if(adapter is SearchAdapter){
                        adapter.setClearList()
                    }
                }
            }


            R.id.tool_item_2 -> {
                Logger.e("저장 기능 on/off")
                account.setBoolean(Const.SAVE_SEARCH_YN, !account.getBoolean(Const.SAVE_SEARCH_YN))
                item.title = saveSearchLabelChange()
            }


            R.id.tool_item_3 -> {
                Logger.e("search 클릭")
            }

            else -> {}
        }

        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navigation = when (item.itemId) {
            R.id.menu_item_1 -> {
                0
            }

            R.id.menu_item_2 -> {
                1
            }

            R.id.menu_item_3 -> {
                2
            }

            else -> {
                0
            }
        }

        if(navigation != binding.pagerLayer.currentItem){
            binding.pagerLayer.currentItem = navigation
        }

        return true
    }

    private val pagerCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
        }
        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
        }

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Logger.e("onPageSelected $position")

            val navigation = when(position) {
                0 -> {
                    R.id.menu_item_1
                }

                1 -> {
                    R.id.menu_item_2
                }

                2 -> {
                    R.id.menu_item_3
                }

                else -> {
                    R.id.menu_item_1
                }
            }

            if(binding.bottomNavi.selectedItemId != navigation){
                binding.bottomNavi.selectedItemId = navigation
            }
        }
    }

    override fun initObserve() {
        super.initObserve()

    }

    private fun saveSearchLabelChange() : String{
        return if(account.getBoolean(Const.SAVE_SEARCH_YN)){
            getString(R.string.tool_menu_3)
        } else {
            getString(R.string.tool_menu_2)
        }
    }

}