package com.example.reddit.data.datasource

import io.reactivex.Completable

interface AuthRemoteDataSource {
    fun updateToken(): Completable
}