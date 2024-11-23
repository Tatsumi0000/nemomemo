package love.aespa.nemomemo.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import love.aespa.nemomemo.database.converter.DateConverter
import love.aespa.nemomemo.database.dao.MemoDao
import love.aespa.nemomemo.database.entity.Memo

@Database(entities = [Memo::class], version = 1)
@ConstructedBy(MemoDatabaseConstructor::class)
@TypeConverters(DateConverter::class)
abstract class MemoDatabase : RoomDatabase() {
    abstract fun getDao(): MemoDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object MemoDatabaseConstructor : RoomDatabaseConstructor<MemoDatabase> {
    override fun initialize(): MemoDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<MemoDatabase>,
): MemoDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
