package com.example.reddit.data.di

import com.example.reddit.data.repository.AuthRepository
import com.example.reddit.data.repository.RedditRepository
import com.example.reddit.domain.repository.AuthDataRepository
import com.example.reddit.domain.repository.RedditDataRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun provideAuthRepository(repository: AuthDataRepository): AuthRepository

    @Binds
    abstract fun provideRedditRepository(repository: RedditDataRepository): RedditRepository
}