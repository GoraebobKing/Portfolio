package kr.co.portfolio.room

import androidx.room.*

/**
 * Created by kwon on 2021/06/24
 **/
@Dao
interface RecentlySearchDao {

    @Insert
    fun inert(response: RecentlySearch)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(response: RecentlySearch)

    @Delete
    fun delete(response: RecentlySearch)

    @Query("SELECT * from SaveSearch ORDER BY seq DESC")
    fun getSearchList(): List<RecentlySearch>

    @Query("SELECT * from SaveSearch where search like ('%'||:str||'%') ORDER BY seq DESC")
    fun getSearch(str : String): List<RecentlySearch>


}