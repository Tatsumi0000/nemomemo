package love.aespa.nemomemo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import love.aespa.nemomemo.database.entity.Memo

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Memo)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(item: Memo)

    @Query("SELECT * FROM memos ORDER BY id ASC")
    fun getAllMemosOrderByIdAsc(): Flow<List<Memo>>

    @Query("SELECT * FROM memos WHERE id = :id")
    fun getMemoById(id: Int): Flow<Memo>
}