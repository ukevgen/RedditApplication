package com.example.reddit.data.di

import com.example.reddit.data.repository.AuthRepository
import com.example.reddit.domain.repository.AuthDataRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun provideAuthRepository(repository: AuthDataRepository): AuthRepository
}