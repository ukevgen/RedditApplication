package com.example.reddit.data.remote.mapper

import com.example.reddit.data.remote.model.PostDataJson
import com.example.reddit.data.remote.model.PostDetailsJson
import com.example.reddit.domain.model.Post
import com.example.reddit.domain.model.PostData
import org.joda.time.DateTime

object DataDomainMapper {

    fun toDomain(postDetailsJson: PostDetailsJson) =
            Post().apply {

                id = postDetailsJson.id
                title = postDetailsJson.title
                likesCount = postDetailsJson.likes
                commentsCount = postDetailsJson.commentsCount
                thumbnail = postDetailsJson.thumbnail
                subreddit = postDetailsJson.subreddit
                score = postDetailsJson.score
                author = postDetailsJson.author
                createdTime = DateTime(postDetailsJson.createdTime)
            }

    fun toDomain(postDataJson: PostDataJson) = PostData(
            postDataJson.lastPostKey,
            postDataJson.postItems.map { toDomain(it.postDetailsJson) }
    )

}