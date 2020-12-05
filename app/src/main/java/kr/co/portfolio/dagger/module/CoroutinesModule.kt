package kr.co.portfolio.dagger.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kr.co.portfolio.dagger.anno.DefaultDispatcher
import kr.co.portfolio.dagger.anno.IoDispatcher
import kr.co.portfolio.dagger.anno.MainDispatcher

/**
 * Created by kwon on 2020/10/15
 **/
@Module
object CoroutinesModule{

    @DefaultDispatcher
    @JvmStatic
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @JvmStatic
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @JvmStatic
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}