package com.example.reddit.data.remote.retrofit.service

import com.example.reddit.data.remote.model.TopPostsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditService {

    @GET("all/top.json")
    fun getPosts(@Query("after") afterPostKey: String,
                 @Query("limit") limit: Int = 10): Single<TopPostsResponse>
}