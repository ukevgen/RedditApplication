package com.example.reddit.data.repository

import io.reactivex.Completable
import io.reactivex.Single

interface AuthRepository {
    fun updateToken(): Completable
}