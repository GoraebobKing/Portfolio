package kr.co.portfolio.room

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.portfolio.data.ProductResponse

/**
 * Created by kwon on 2021/06/24
 **/
@Database(entities = [RecentlySearch::class, ProductResponse::class], version = 3, exportSchema = false)
abstract class DataBaseModule : RoomDatabase(){

    abstract fun todoDao(): RecentlySearchDao
    abstract fun todoProductDao(): ProductResponseDao
}