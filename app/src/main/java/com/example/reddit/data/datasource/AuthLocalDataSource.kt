package com.example.reddit.data.datasource

import io.reactivex.Completable

interface AuthLocalDataSource {
    fun updateToken(token: String): Completable
}