package kr.co.portfolio.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by kwon on 2020/09/24
 **/
//class SampleApp : Application(), HasAndroidInjector {
//
//    @Inject
//    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
//
//    override fun androidInjector(): AndroidInjector<Any> {
//        return dispatchingAndroidInjector
//    }
//
//
//    override fun onCreate() {
//        super.onCreate()
//        DaggerAppComponent.factory().create(this).inject(this)
//    }
//
//}

@HiltAndroidApp
class SampleApp : Application(){

}