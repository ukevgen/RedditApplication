package com.example.reddit.domain.repository

import com.example.reddit.data.datasource.AuthLocalDataSource
import com.example.reddit.data.datasource.AuthRemoteDataSource
import com.example.reddit.data.repository.AuthRepository
import io.reactivex.Completable
import javax.inject.Inject

class AuthDataRepository @Inject constructor(private val remoteDataSource: AuthRemoteDataSource,
                                             private val localDataSource: AuthLocalDataSource) : AuthRepository {

    override fun updateToken(): Completable {
        return remoteDataSource.getToken()
                .flatMapCompletable { token ->
                    localDataSource.updateToken(token)
                }
    }
}