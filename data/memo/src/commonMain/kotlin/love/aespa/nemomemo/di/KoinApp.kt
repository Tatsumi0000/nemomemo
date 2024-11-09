package love.aespa.nemomemo.di

import love.aespa.nemomemo.database.di.databaseModule
import love.aespa.nemomemo.repository.di.memoRepositoryModule

fun appModule() = listOf(
    memoRepositoryModule,
    databaseModule()
)