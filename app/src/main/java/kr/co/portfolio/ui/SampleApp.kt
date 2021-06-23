package kr.co.portfolio.ui

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
//import kr.co.portfolio.dagger.component.DaggerAppComponent
import javax.inject.Inject

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

class SampleApp : Application(){

}