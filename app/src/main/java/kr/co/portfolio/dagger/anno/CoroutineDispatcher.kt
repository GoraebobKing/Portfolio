package kr.co.portfolio.dagger.anno

import javax.inject.Qualifier

/**
 * Created by kwon on 2020/10/15
 **/

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher