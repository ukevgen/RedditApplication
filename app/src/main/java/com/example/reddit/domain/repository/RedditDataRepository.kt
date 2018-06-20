package com.example.reddit.domain.repository

import com.example.reddit.data.datasource.RedditRemoteDataSource
import com.example.reddit.data.repository.RedditRepository
import com.example.reddit.domain.model.PostData
import io.reactivex.Single
import javax.inject.Inject

class RedditDataRepository @Inject constructor(private val remoteDataSource: RedditRemoteDataSource) : RedditRepository {

    override fun getPosts(afterPostKey: String): Single<PostData> {
        return remoteDataSource.getPosts(afterPostKey)
    }
}