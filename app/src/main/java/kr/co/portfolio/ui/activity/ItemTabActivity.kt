package kr.co.portfolio.ui.activity

import android.app.SearchManager
import android.content.Context
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityItemTabBinding
import kr.co.portfolio.ui.fragment.*
import kr.co.portfolio.util.FragmentExtension.hideAndShowFragment
import kr.co.portfolio.util.Logger
import kr.co.portfolio.viewmodel.ItemViewModel


@AndroidEntryPoint
class ItemTabActivity : BaseActivity<ActivityItemTabBinding, ItemViewModel>(),
    BottomNavigationView.OnNavigationItemSelectedListener, Toolbar.OnMenuItemClickListener {

    private val itemViewModel : ItemViewModel by viewModels()

    override fun getLayoutResId() = R.layout.activity_item_tab
    override fun getViewModel() = itemViewModel

    private var itemFragment : ItemFragment?= null


    override fun initView() {
        binding.view = this
        binding.vm = itemViewModel

        setSupportActionBar(binding.toolbar)

        binding.bottomNavi.setOnNavigationItemSelectedListener(this@ItemTabActivity)
        binding.bottomNavi.selectedItemId = R.id.menu_item_1

        binding.toolbar.setOnMenuItemClickListener(this@ItemTabActivity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Logger.e("onCreateOptionsMenu")
        menuInflater.inflate(R.menu.menu_toolbar, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.tool_item_3).actionView as SearchView).apply{
            this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Logger.e("Query $query")
                    clearFocus()
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    Logger.e("Query $newText")
                    return false
                }
            })

            this.setOnFocusChangeListener { _, hasFocus ->
                Logger.e("SearchView hasFocus : $hasFocus")
                if(hasFocus){

                } else {

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
            }


            R.id.tool_item_2 -> {
                Logger.e("저장 기능 on/off")
            }


            R.id.tool_item_3 -> {
                Logger.e("search 클릭")
            }

            else -> {}
        }

        return true
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