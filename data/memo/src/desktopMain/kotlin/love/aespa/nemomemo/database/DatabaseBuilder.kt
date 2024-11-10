package love.aespa.nemomemo.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

actual fun getDatabaseBuilder(): RoomDatabase.Builder<MemoDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "nemomemo.db")
    return Room.databaseBuilder<MemoDatabase>(
        name = dbFile.absolutePath,
    )
}
