package com.example.reddit.data.remote.mapper

import com.example.reddit.data.remote.model.PostDataJson
import com.example.reddit.data.remote.model.PostJson
import com.example.reddit.domain.model.Post
import com.example.reddit.domain.model.PostData
import org.joda.time.DateTime

object DataDomainMapper {

    val redditHost = "https://www.reddit.com"

    fun toDomain(postJson: PostJson) =
            Post().apply {

                id = postJson.id
                title = postJson.title
                likesCount = postJson.likes
                commentsCount = postJson.commentsCount
                thumbnail = postJson.thumbnail
                subreddit = postJson.subreddit
                score = postJson.score
                author = postJson.author
                createdTime = DateTime(postJson.createdTime * 1000)
                articleLink = redditHost + postJson.articleLink
            }

    fun toDomain(postDataJson: PostDataJson) = PostData(
            postDataJson.lastPostKey,
            postDataJson.postItems.map { toDomain(it.postJson) }
    )

}