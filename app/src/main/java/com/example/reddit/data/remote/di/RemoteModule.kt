package com.example.reddit.data.remote.di

import com.example.reddit.data.datasource.AuthRemoteDataSource
import com.example.reddit.data.datasource.RedditRemoteDataSource
import com.example.reddit.data.remote.AuthRemoteDataSourceImpl
import com.example.reddit.data.remote.RedditRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteModule {

    @Binds
    abstract fun provideAuthRemote(authRemoteDataSourceImpl: AuthRemoteDataSourceImpl): AuthRemoteDataSource

    @Binds
    abstract fun provideRedditRemote(redditRemoteDataSourceImpl: RedditRemoteDataSourceImpl): RedditRemoteDataSource

}