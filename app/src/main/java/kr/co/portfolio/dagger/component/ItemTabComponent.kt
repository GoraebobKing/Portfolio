package kr.co.portfolio.dagger.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import kr.co.portfolio.ui.activity.ItemTabActivity
import kr.co.portfolio.ui.activity.NetworkActivity
import kr.co.portfolio.ui.activity.TabActivity

/**
 * Created by kwon on 2020/10/12
 * 액티비티 사용을 위해 만들었으며, 하단에 별도로 의존성 주입하기 위해 클래스별로 사용?
 **/
@Subcomponent
interface ItemTabComponent : AndroidInjector<ItemTabActivity>{

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ItemTabActivity>
}