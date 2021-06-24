package kr.co.portfolio.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

/**
 * Created by kwon on 2021/06/24
 **/
@Dao
interface RecentlySearchDao {


//    @Query("SELECT * from SaveSearch ORDER BY title DESC")
//    fun getAll(): List<RecentlySearch>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(response: RecentlySearch)
}