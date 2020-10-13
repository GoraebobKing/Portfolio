package kr.co.portfolio.viewmodel

import android.util.Log
import kr.co.portfolio.data.User
import kr.co.portfolio.network.GithubApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by kwon on 2020/09/24
 **/
class AnotherViewModel @Inject constructor(private val githubApi: GithubApi): BaseViewModel() {

    fun startApi(){
        Log.e("AnotherViewModel", "붏러짐 AnotherViewModel")
        githubApi.getUsers().enqueue(object : Callback<List<User>> {	// 3️⃣
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("githubApi", "Retrofit2 onFailure - ${t}")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(!response.isSuccessful) return

                var userList :List<User> = response.body()!!
                Log.d("githubApi", "userList Count is ${userList.size}")

                for ((index, user) in userList.withIndex())
                    Log.d("githubApi", "user count $index => ${user}")
            }
        })
    }

}