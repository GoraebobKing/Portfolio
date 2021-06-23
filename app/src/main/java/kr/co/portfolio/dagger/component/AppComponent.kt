package kr.co.portfolio.dagger.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import kr.co.portfolio.dagger.module.*
import kr.co.portfolio.ui.SampleApp
import javax.inject.Singleton

/**
 * Created by kwon on 2020/10/12
 * Dagger2 관련 작업 (
 * https://jaejong.tistory.com/125?category=873925
 * https://medium.com/@marco_cattaneo/android-viewmodel-and-factoryprovider-good-way-to-manage-it-with-dagger-2-d9e20a07084c
 * 참조)
 *
 * inject : 의존성을 객체 주입을 요청하는 부분
 * BindsInstance : 정확한 의미는 잘 모르겠지만 저것으로 인자값을 받으면 dagger안에서 어디든지 사용가능?한 것으로 보인다.
 * 인터페이스 설명
 * 최상단 대거 사용을 위한 부모 컴포넌트로 하위 모듈들을 선언?한다.
 * create에서 context를 받아 사용하기 위해서 BindsInstance 를 사용함
 * inject 엣 application 을 받은 이유는 같은 생명주기를 타기 위해서.
 *
 * Component
 * AndroidInjectionModule : 기본적으로 dagger를 사용하기 위해서 넣어주는?클래스
 * ActivityBindingModule : activity관련 의존성을 위해 생성한 클래스?fragment도 가능
 * RetrofitModule 을 사용하기 위해 만든 모듈
 * ViewModelModule : 뷰모델을 만들고 의존성을 주입하기 위해 만든 모듈
 * ViewModelFactoryModule : 뷰모델 사용시 보일러코드를 줄이기 위해 사용한 모듈
 **/

//@Singleton
//@Component(modules = [
//    AndroidInjectionModule::class,
//    ActivityBindingModule::class,
//    RetrofitModule::class,
//    ViewModelModule::class,
//    ViewModelFactoryModule::class,
//    CoroutinesModule::class,
//    RepositoryModule::class
//])
//interface AppComponent {
//
//    @Component.Factory
//    interface Factory {
//        fun create(@BindsInstance context: Context) : AppComponent
//    }
//
//    fun inject(sampleApp: SampleApp)
//}