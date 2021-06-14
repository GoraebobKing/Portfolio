package kr.co.portfolio.dagger.module

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kr.co.portfolio.dagger.anno.ViewModelKey
import kr.co.portfolio.viewmodel.*

/**
 * Created by kwon on 2020/10/13
 **/

@Module
class ViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(DaggerViewModel::class)
    fun provideDaggerViewModel(daggerViewModel: DaggerViewModel) : ViewModel{
        return daggerViewModel
    }

    @Provides
    @IntoMap
    @ViewModelKey(AnotherViewModel::class)
    fun provideAnotherViewModel(anotherViewModel: AnotherViewModel) : ViewModel{
        return anotherViewModel
    }

    @Provides
    @IntoMap
    @ViewModelKey(CoroutineViewModel::class)
    fun provideCoroutineViewModel(coroutineViewModel: CoroutineViewModel) : ViewModel{
        return coroutineViewModel
    }

    @Provides
    @IntoMap
    @ViewModelKey(NetworkViewModel::class)
    fun provideNetworkViewModel(networkViewModel: NetworkViewModel) : ViewModel{
        return networkViewModel
    }
}