package love.aespa.nemomemo.database.di

import love.aespa.nemomemo.database.MemoDatabase
import love.aespa.nemomemo.database.getDatabaseBuilder
import love.aespa.nemomemo.database.getRoomDatabase
import org.koin.dsl.module

actual fun databaseModule() = module {
    single<MemoDatabase> { getRoomDatabase(getDatabaseBuilder()) }
}