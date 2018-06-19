package com.example.reddit.data.remote

import com.example.reddit.data.datasource.AuthRemoteDataSource
import com.example.reddit.data.remote.retrofit.service.AuthService
import io.reactivex.Completable
import java.util.*
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val authService: AuthService) : AuthRemoteDataSource {

    private val AUTH_GRANT_TYPE = "https://oauth.reddit.com/grants/installed_client"

    override fun updateToken(): Completable {
        return authService.updateToken(UUID.randomUUID().toString(), AUTH_GRANT_TYPE)
                .flatMapCompletable { Completable.complete() }
    }
}