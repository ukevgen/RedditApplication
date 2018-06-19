package com.example.reddit.data.remote.di

import com.example.reddit.data.datasource.AuthRemoteDataSource
import com.example.reddit.data.remote.AuthRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteModule {

    @Binds
    abstract fun provideAuthRemote(authRemoteDataSourceImpl: AuthRemoteDataSourceImpl): AuthRemoteDataSource

}