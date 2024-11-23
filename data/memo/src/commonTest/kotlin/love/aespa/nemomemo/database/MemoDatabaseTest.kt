package love.aespa.nemomemo.database

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import love.aespa.nemomemo.database.dao.MemoDao
import love.aespa.nemomemo.database.entity.Memo
import java.util.Date
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MemoDatabaseTest {

    private lateinit var db: MemoDatabase
    private lateinit var dao: MemoDao

    @BeforeTest
    fun setUp() {
        db = getInMemoryDataBase().setDriver(BundledSQLiteDriver()).build()
        dao = db.getDao()
    }

    @AfterTest
    fun tearDown() {
        db.close()
    }

    @Test
    fun getAllMemosOrderByIdAscTest() = runTest {
        val testLength = 3
        testData(testLength).map {
            dao.insert(it)
        }
        val result = dao.getAllMemosOrderByIdAsc().first()
        assertEquals(testLength, result.size)
    }

    private fun testData(testLength: Int): List<Memo> {
        val testData = List(testLength) { count ->
            val count = count + 1
            Memo(id = 0, text = "Hoge-$count", createdAt = Date(), updatedAd = Date())
        }
        return testData
    }
}
