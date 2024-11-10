package love.aespa.nemomemo.database

import androidx.room.RoomDatabase

expect fun getInMemoryDataBase(): RoomDatabase.Builder<MemoDatabase>