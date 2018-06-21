package com.example.reddit.data.remote.model

import com.example.reddit.EmptyConstants
import com.google.gson.annotations.SerializedName

class PostJson {

    @field:SerializedName("id")
    val id = EmptyConstants.EMPTY_STRING

    @field:SerializedName("title")
    val title = EmptyConstants.EMPTY_STRING

    @field:SerializedName("likes")
    val likes: Long? = null

    @field:SerializedName("num_comments")
    val commentsCount: Long? = null

    @field:SerializedName("thumbnail")
    val thumbnail = EmptyConstants.EMPTY_STRING

    @field:SerializedName("subreddit")
    val subreddit = EmptyConstants.EMPTY_STRING

    @field:SerializedName("score")
    val score = EmptyConstants.EMPTY_LONG

    @field:SerializedName("author")
    val author: String = EmptyConstants.EMPTY_STRING

    @field:SerializedName("created_utc")
    val createdTime = EmptyConstants.EMPTY_LONG

    @field:SerializedName("permalink")
    val articleLink: String? = null
}