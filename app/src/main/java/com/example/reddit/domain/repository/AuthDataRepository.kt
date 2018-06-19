package com.example.reddit.domain.repository

import com.example.reddit.data.datasource.AuthRemoteDataSource
import com.example.reddit.data.repository.AuthRepository
import io.reactivex.Completable
import javax.inject.Inject

class AuthDataRepository @Inject constructor(private val remoteDataSource: AuthRemoteDataSource) : AuthRepository {

    override fun updateToken(): Completable {
        return remoteDataSource.updateToken()
    }
}