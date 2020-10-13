package kr.co.portfolio.dagger.module

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import kr.co.portfolio.dagger.component.AnotherComponent
import kr.co.portfolio.dagger.component.DaggerComponent
import kr.co.portfolio.ui.activity.AnotherActivity
import kr.co.portfolio.ui.activity.DaggerActivity

/**
 * Created by kwon on 2020/10/12
 * Binds : Module에서 제공하고자 하는 클래스의 구현체(interface 구현체, 즉 객체)를 바인딩하고자 할 때 사용, 추상메소드에 사용
 * IntoMap : 멀티 바인딩에서 사용하면서 키값을 가지고 체크
 **/
@Module(subcomponents = [
    DaggerComponent::class,
    AnotherComponent::class
])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ClassKey(DaggerActivity::class)
    abstract fun bindDaggerInjectorFactory(factory: DaggerComponent.Factory) : AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(AnotherActivity::class)
    abstract fun bindAnotherInjectorFactory(factory: AnotherComponent.Factory) : AndroidInjector.Factory<*>
}