package love.aespa.nemomemo.database

import androidx.room.Room
import androidx.room.RoomDatabase

actual fun getInMemoryDataBase(): RoomDatabase.Builder<MemoDatabase> {
    return Room.inMemoryDatabaseBuilder<MemoDatabase>()
}
