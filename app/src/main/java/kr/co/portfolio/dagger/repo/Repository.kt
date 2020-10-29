package kr.co.portfolio.dagger.repo

import kr.co.portfolio.data.ResultData
import kr.co.portfolio.data.User

/**
 * Created by kwon on 2020/10/15
 **/
interface Repository {

    suspend fun getRepoUsers() : ResultData<List<User>>
}