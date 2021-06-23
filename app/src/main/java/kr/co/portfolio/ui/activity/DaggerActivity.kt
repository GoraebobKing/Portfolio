package kr.co.portfolio.ui.activity

import kr.co.portfolio.R
import kr.co.portfolio.databinding.ActivityDaggerBinding
import kr.co.portfolio.viewmodel.BaseViewModel


/**
 * Created by kwon on 2020/09/24
 **/
class DaggerActivity : BaseActivity<ActivityDaggerBinding, BaseViewModel>() {

    override fun getLayoutResId() = R.layout.activity_dagger
    override fun getModelId() = BaseViewModel::class.java

//    @Inject
//    lateinit var githubApi: GithubApi

    override fun initView() {
//        viewModel.startApi()
//        githubApi.getUsers().enqueue(object : Callback<List<User>> {	//
//            override fun onFailure(call: Call<List<User>>, t: Throwable) {
//                Log.e("githubApi", "Retrofit2 onFailure - ${t}")
//            }
//
//            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                if(!response.isSuccessful) return
//
//                var userList :List<User> = response.body()!!
//                Log.d("githubApi", "userList Count is ${userList.size}")
//
//                for ((index, user) in userList.withIndex())
//                    Log.d("githubApi", "user count $index => ${user}")
//            }
//        })

    }
}