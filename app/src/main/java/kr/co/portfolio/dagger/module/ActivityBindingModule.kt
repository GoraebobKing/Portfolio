package kr.co.portfolio.dagger.module

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import kr.co.portfolio.dagger.component.*
import kr.co.portfolio.ui.activity.*

/**
 * Created by kwon on 2020/10/12
 * Binds : Module에서 제공하고자 하는 클래스의 구현체(interface 구현체, 즉 객체)를 바인딩하고자 할 때 사용, 추상메소드에 사용
 * IntoMap : 멀티 바인딩에서 사용하면서 키값을 가지고 체크
 **/
@Module(subcomponents = [
    TabComponent::class,
    MainComponent::class,
    AnotherComponent::class,
    DaggerComponent::class,
    NetworkComponent::class,
    ItemTabComponent::class
])
abstract class ActivityBindingModule {

//    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
//    abstract fun contributesDetailsActivity(): DetailsActivity

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindMainInjectorFactory(factory: MainComponent.Factory) : AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(TabActivity::class)
    abstract fun bindTabInjectorFactory(factory: TabComponent.Factory) : AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(DaggerActivity::class)
    abstract fun bindDaggerInjectorFactory(factory: DaggerComponent.Factory) : AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(AnotherActivity::class)
    abstract fun bindAnotherInjectorFactory(factory: AnotherComponent.Factory) : AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(NetworkActivity::class)
    abstract fun bindNetworkInjectorFactory(factory: NetworkComponent.Factory) : AndroidInjector.Factory<*>


    @Binds
    @IntoMap
    @ClassKey(ItemTabActivity::class)
    abstract fun bindItemTabInjectorFactory(factory: ItemTabComponent.Factory) : AndroidInjector.Factory<*>
}