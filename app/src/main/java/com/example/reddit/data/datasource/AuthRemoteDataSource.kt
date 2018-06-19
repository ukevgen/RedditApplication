package com.example.reddit.data.datasource

import io.reactivex.Single

interface AuthRemoteDataSource {
    fun getToken(): Single<String>
}