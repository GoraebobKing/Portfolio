package kr.co.portfolio.dagger.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import kr.co.portfolio.ui.activity.DaggerActivity

/**
 * Created by kwon on 2020/10/12
 * 액티비티 사용을 위해 만들었으며, 하단에 별도로 의존성 주입하기 위해 클래스별로 사용?
 **/
@Subcomponent(modules = [])
interface DaggerComponent : AndroidInjector<DaggerActivity>{

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<DaggerActivity>
}