package kr.co.portfolio.dagger.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import kr.co.portfolio.viewmodel.ViewModelFactory

/**
 * Created by kwon on 2020/10/13
 **/
@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory : ViewModelFactory) : ViewModelProvider.Factory
}