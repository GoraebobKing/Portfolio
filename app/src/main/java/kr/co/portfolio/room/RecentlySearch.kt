package kr.co.portfolio.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by kwon on 2021/06/24
 **/
@Entity(tableName = "SaveSearch")
class RecentlySearch (
    @PrimaryKey
    var search : String
){
//    @PrimaryKey(autoGenerate = true)
//    var seq : Int? = null
}
