package kr.co.portfolio.room

import androidx.room.*
import kr.co.portfolio.data.ProductResponse

/**
 * Created by kwon on 2021/07/05
 **/
@Dao
interface ProductResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inert(response: ProductResponse)

    @Delete
    suspend fun delete(response: ProductResponse)

    @Query("SELECT id from PRODUCT")
    suspend fun getFavoriteIdList() : List<Int>
}