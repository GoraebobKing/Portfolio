package kr.co.portfolio.ui.activity

import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityTabBinding
import kr.co.portfolio.ui.fragment.*
import kr.co.portfolio.util.FragmentExtension.hideAndShowFragment
import kr.co.portfolio.viewmodel.BaseViewModel

/**
 * Created by kwon on 2021/06/05
 **/
class TabActivity : BaseActivity<ActivityTabBinding, BaseViewModel>() {

    override fun getLayoutResId() = R.layout.activity_tab
    override fun getViewModel(): BaseViewModel? {
        return null
    }

    //뭔가 할게 생기면 명칭 변경하여 작업
    private var motionFragment : MotionLayoutFragment? = null
    private var coordiFragment : CoordinatorFragment? = null
    private var emptyFragment2 : EmptyFragment2? = null
    private var emptyFragment3 : EmptyFragment3? = null


    override fun initView() {
//        binding.bottomNavi.setOnNavigationItemSelectedListener(this@TabActivity)
//        binding.bottomNavi.selectedItemId = R.id.menu_item_1
    }



//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.bottom_menu_1 -> {
//
//                if (motionFragment == null) {
//                    motionFragment = MotionLayoutFragment()
//                }
//
//                motionFragment?.let {
//                    hideAndShowFragment(it)
//                }
//
//                return true
//            }
//
//            R.id.bottom_menu_2 -> {
//                if (coordiFragment == null) {
//                    coordiFragment = CoordinatorFragment()
//                }
//
//                coordiFragment?.let {
//                    hideAndShowFragment(it)
//                }
//
//                return true
//            }
//
//            R.id.bottom_menu_3 -> {
//                if (emptyFragment2 == null) {
//                    emptyFragment2 = EmptyFragment2()
//                }
//
//                emptyFragment2?.let {
//                    hideAndShowFragment(it)
//                }
//
//                return true
//            }
//
//            R.id.bottom_menu_4 -> {
//                if (emptyFragment3 == null) {
//                    emptyFragment3 = EmptyFragment3()
//                }
//
//                emptyFragment3?.let {
//                    hideAndShowFragment(it)
//                }
//
//                return true
//            }
//        }
//        return false
//    }
}