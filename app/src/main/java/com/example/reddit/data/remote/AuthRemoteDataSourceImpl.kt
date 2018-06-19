package com.example.reddit.data.remote

import com.example.reddit.data.datasource.AuthRemoteDataSource
import com.example.reddit.data.remote.retrofit.service.AuthService
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val authService: AuthService) : AuthRemoteDataSource {

    private val AUTH_GRANT_TYPE = "https://oauth.reddit.com/grants/installed_client"

    override fun getToken(): Single<String> {
        return authService.updateToken(UUID.randomUUID().toString(), AUTH_GRANT_TYPE)
                .map { response ->
                    val json = Gson().fromJson<JsonObject>(response.string(), JsonObject::class.java)
                    val token = json.get("access_token").asString
                    token
                }
    }

}