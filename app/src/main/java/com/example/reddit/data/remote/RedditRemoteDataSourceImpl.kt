package com.example.reddit.data.remote

import com.example.reddit.data.datasource.RedditRemoteDataSource
import com.example.reddit.data.remote.mapper.DataDomainMapper
import com.example.reddit.data.remote.retrofit.service.RedditService
import com.example.reddit.domain.model.PostData
import io.reactivex.Single
import javax.inject.Inject

class RedditRemoteDataSourceImpl @Inject constructor(private val redditService: RedditService) : RedditRemoteDataSource {

    override fun getPosts(afterPostKey: String): Single<PostData> {
        return redditService.getPosts(afterPostKey)
                .map { response ->
                    DataDomainMapper.toDomain(response.data)
                }
    }
}