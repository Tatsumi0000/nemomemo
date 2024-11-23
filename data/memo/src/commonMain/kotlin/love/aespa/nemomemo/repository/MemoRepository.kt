package love.aespa.nemomemo.repository

import kotlinx.coroutines.flow.Flow
import love.aespa.nemomemo.database.MemoDatabase
import love.aespa.nemomemo.database.entity.Memo

interface MemoRepository {
    fun getAllMemosOrderByIdAsc(): Flow<List<Memo>>
    suspend fun insert(memo: Memo)
}
class MemoRepositoryImpl(
    private val database: MemoDatabase,
) : MemoRepository {
    override fun getAllMemosOrderByIdAsc(): Flow<List<Memo>> = database.getDao().getAllMemosOrderByIdAsc()

    override suspend fun insert(memo: Memo) = database.getDao().insert(memo)
}
