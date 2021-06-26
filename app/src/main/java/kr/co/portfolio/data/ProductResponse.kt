package kr.co.portfolio.data

import com.google.gson.annotations.SerializedName

/**
 * Created by kwon on 2020/09/24
 **/


data class ProductResponse(
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("title")
    var title : String? = null,
    @SerializedName("price")
    var price : Double = 0.0,
    @SerializedName("description")
    var description : String? = null,
    @SerializedName("category")
    var category : String? = null,
    @SerializedName("image")
    var image : String? = null,
    var checked : Boolean = false
)
