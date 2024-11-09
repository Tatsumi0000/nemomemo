package love.aespa.nemomemo.database

import androidx.room.ConstructedBy
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import love.aespa.nemomemo.converter.DateConverter
import love.aespa.nemomemo.entity.Memo

@Database(entities = [Memo::class], version = 1)
@ConstructedBy(MemoDatabaseConstructor::class)
@TypeConverters(DateConverter::class)
abstract class MemoDatabase: RoomDatabase() {
    abstract fun getDao(): MemoDao
}


@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object MemoDatabaseConstructor : RoomDatabaseConstructor<MemoDatabase> {
    override fun initialize(): MemoDatabase
}


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