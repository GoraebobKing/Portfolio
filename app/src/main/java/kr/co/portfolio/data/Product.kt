package kr.co.portfolio.data

import com.google.gson.annotations.SerializedName

/**
 * Created by kwon on 2020/09/24
 **/


data class Product(
    @SerializedName("id")
    private var id : Int = 0,
    @SerializedName("title")
    private var title : String? = null,
    @SerializedName("price")
    private var price : Double = 0.0,
    @SerializedName("price")
    private var description : String? = null,
    @SerializedName("category")
    private var category : String? = null,
    @SerializedName("image")
    private var image : String? = null,
)
