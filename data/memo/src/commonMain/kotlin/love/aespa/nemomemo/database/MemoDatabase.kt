package love.aespa.nemomemo.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import love.aespa.nemomemo.converter.DateConverter
import love.aespa.nemomemo.dao.MemoDao
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