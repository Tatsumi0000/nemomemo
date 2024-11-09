package love.aespa.nemomemo.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import love.aespa.nemomemo.database.MemoDatabase
import love.aespa.nemomemo.database.entity.Memo

interface MemoRepository {
    fun getAllMemosOrderByIdAsc(): Flow<List<Memo>>
    suspend fun insert(memo: Memo)
}
class MemoRepositoryImpl(
    private val database: MemoDatabase
): MemoRepository {
    override fun getAllMemosOrderByIdAsc(): Flow<List<Memo>> = database.getDao().getAllMemosOrderByIdAsc()

    override suspend fun insert(memo: Memo) = database.getDao().insert(memo)
}