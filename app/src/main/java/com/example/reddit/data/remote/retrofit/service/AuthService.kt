package com.example.reddit.data.remote.retrofit.service

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {

    @POST("access_token/")
    fun updateToken(@Query("device_id") deviceId: String,
                    @Query("grant_type") grantType: String
    ): Single<ResponseBody>
}