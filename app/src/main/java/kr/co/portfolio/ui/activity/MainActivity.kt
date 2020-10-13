package kr.co.portfolio.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityMainBinding
import kr.co.portfolio.ui.fragment.CoordinatorFragment
import kr.co.portfolio.ui.fragment.CustomFragment
import kr.co.portfolio.ui.fragment.HomeFragment
import kr.co.portfolio.ui.fragment.RxKotlinFragment


/**
 * 메인 페이지에는 바텀 네비게이션바를 이용한 구조를 생성
 * **/
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding : ActivityMainBinding

    private lateinit var trantion : FragmentTransaction
    private lateinit var fm : FragmentManager

    private lateinit var homeFragment : HomeFragment
    private lateinit var coordiFragment : CoordinatorFragment
    private lateinit var customFragment: CustomFragment
    private lateinit var rxFragment: RxKotlinFragment

    private var fragmentArray = ArrayList<Fragment>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fm = supportFragmentManager
        trantion = fm.beginTransaction()

        homeFragment = HomeFragment()
        trantion.add(R.id.frame_layer, homeFragment).commitAllowingStateLoss()
        fragmentArray.add(homeFragment)
        binding.bottomNavi.setOnNavigationItemSelectedListener(this@MainActivity)

    }

    private fun hideAndShowFragment(thisFragment : Fragment){

        fm.fragments.forEach {
            if(it == thisFragment){
                trantion.show(it)
            } else {
                trantion.hide(it)
            }
        }

        trantion.commitAllowingStateLoss()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        trantion = fm.beginTransaction()

        when(item.itemId){

            R.id.bottom_menu_1 -> {
                Log.e("TAG", "하단 모션레이아웃 버튼 클릭")
                if(::homeFragment.isInitialized){
                    hideAndShowFragment(homeFragment)
                } else {
                    homeFragment = HomeFragment()
                    trantion.add(R.id.frame_layer, homeFragment).commitAllowingStateLoss()
                }
            }

            R.id.bottom_menu_2 -> {
                Log.e("TAG", "하단 코디네이터 버튼 클릭")
                if(::coordiFragment.isInitialized){
                    hideAndShowFragment(coordiFragment)
                } else {
                    coordiFragment = CoordinatorFragment()
                    trantion.add(R.id.frame_layer, coordiFragment).commitAllowingStateLoss()
                    fragmentArray.add(coordiFragment)
                }
            }

            R.id.bottom_menu_3 -> {
                Log.e("TAG", "하단 커스텀 버튼 클릭")
                if(::customFragment.isInitialized){
                    hideAndShowFragment(customFragment)
                } else {
                    customFragment = CustomFragment()
                    trantion.add(R.id.frame_layer, customFragment).commitAllowingStateLoss()
                    fragmentArray.add(customFragment)
                }
            }

            else -> {
                Log.e("TAG", "하단 RX연습 버튼 클릭")
                if(::rxFragment.isInitialized){
                    hideAndShowFragment(rxFragment)
                } else {
                    rxFragment = RxKotlinFragment()
                    trantion.add(R.id.frame_layer, rxFragment).commitAllowingStateLoss()
                    fragmentArray.add(rxFragment)
                }
            }
        }

        return true
    }
}