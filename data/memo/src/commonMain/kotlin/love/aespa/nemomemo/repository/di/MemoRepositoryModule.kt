package love.aespa.nemomemo.repository.di

import love.aespa.nemomemo.repository.MemoRepository
import love.aespa.nemomemo.repository.MemoRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val memoRepositoryModule = module {
    singleOf(::MemoRepositoryImpl) bind MemoRepository::class
}
