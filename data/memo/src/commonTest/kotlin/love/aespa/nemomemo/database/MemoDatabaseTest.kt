package love.aespa.nemomemo.database

import kotlinx.coroutines.test.runTest
import love.aespa.nemomemo.database.dao.MemoDao
import love.aespa.nemomemo.database.entity.Memo
import java.util.Date
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class MemoDatabaseTest {

    private lateinit var db: MemoDatabase
    private lateinit var dao: MemoDao

    @BeforeTest
    fun setUp() {
        db = getRoomDatabase(getDatabaseBuilder())
        dao = db.getDao()
    }

    @AfterTest
    fun tearDown() {
        db.close()
    }

    @Test
    fun getAllMemosOrderByIdAscTest() = runTest {
        testData(testSize = 3).map { dao.insert(it) }
    }


    private fun testData(testSize: Int): List<Memo> {
        val testData = List(testSize) { count ->
            Memo(id = count, text = "Hoge-$count", createdAt = Date(), updatedAd = Date())
        }
        return testData
    }

}