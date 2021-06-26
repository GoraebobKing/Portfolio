package kr.co.portfolio.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by kwon on 2021/06/24
 **/
@Entity(tableName = "SaveSearch")
data class RecentlySearch (

    @PrimaryKey(autoGenerate = true)
    var seq : Int,
    var search : String


)