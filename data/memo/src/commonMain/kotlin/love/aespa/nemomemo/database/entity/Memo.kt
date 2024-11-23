package love.aespa.nemomemo.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "memos")
data class Memo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String = "",
    @ColumnInfo(name = "created_at")
    val createdAt: Date,
    @ColumnInfo(name = "updated_at")
    val updatedAd: Date,
)
