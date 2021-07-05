package kr.co.portfolio.room

import androidx.room.*

/**
 * Created by kwon on 2021/06/24
 **/
@Dao
interface RecentlySearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inert(response: RecentlySearch)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(response: RecentlySearch)

    @Delete
    suspend fun delete(response: RecentlySearch)

    @Query("DELETE FROM SaveSearch")
    suspend fun clearAll()

    @Query("SELECT * from SaveSearch")
    suspend fun getSearchList(): List<RecentlySearch>
//    @Query("SELECT * from SaveSearch ORDER BY seq DESC")
//    suspend fun getSearchList(): List<RecentlySearch>

    @Query("SELECT * from SaveSearch where search like ('%'||:str||'%')")
    suspend fun getSearch(str: String): List<RecentlySearch>
//    @Query("SELECT * from SaveSearch where search like ('%'||:str||'%') ORDER BY seq DESC")
//    suspend fun getSearch(str : String): List<RecentlySearch>


}