package com.example.reddit.data.datasource

import com.example.reddit.domain.model.PostData
import io.reactivex.Single

interface RedditRemoteDataSource {
    fun getPosts(afterPostKey: String): Single<PostData>
}