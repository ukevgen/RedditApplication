package com.example.reddit.data.repository

import com.example.reddit.domain.model.PostData
import io.reactivex.Single

interface RedditRepository {
    fun getPosts(afterPostKey: String): Single<PostData>
}