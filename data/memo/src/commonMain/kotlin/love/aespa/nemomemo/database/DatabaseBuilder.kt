package love.aespa.nemomemo.database

import androidx.room.RoomDatabase

expect fun           getDatabaseBuilder(): RoomDatabase.Builder<MemoDatabase>