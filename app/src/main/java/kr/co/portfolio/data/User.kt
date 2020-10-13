package kr.co.portfolio.data

import com.google.gson.annotations.SerializedName

/**
 * Created by kwon on 2020/09/24
 **/


data class User(
    @SerializedName("id")
    private var id : String,
    @SerializedName("login")
    private var login : String,
    @SerializedName("html_url")
    private var htmlUrl : String
)