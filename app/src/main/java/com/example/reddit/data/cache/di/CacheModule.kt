package com.example.reddit.data.cache.di

import com.example.reddit.data.cache.AuthLocalDataSourceImpl
import com.example.reddit.data.datasource.AuthLocalDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class CacheModule {
    @Binds
    abstract fun provideAuthLocal(authLocalDataSourceImpl: AuthLocalDataSourceImpl): AuthLocalDataSource

}