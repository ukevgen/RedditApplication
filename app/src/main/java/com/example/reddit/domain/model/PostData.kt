package com.example.reddit.domain.model

import com.example.reddit.EmptyConstants
import org.joda.time.DateTime

data class PostData(val lastPostKey: String, val posts: List<Post>)

class Post {

    var title: String = EmptyConstants.EMPTY_STRING
    var likesCount: Long? = null
    var id = EmptyConstants.EMPTY_STRING
    var commentsCount: Long? = null
    var thumbnail = EmptyConstants.EMPTY_STRING
    var subreddit = EmptyConstants.EMPTY_STRING
    var score = EmptyConstants.EMPTY_LONG
    var author = EmptyConstants.EMPTY_STRING
    var createdTime = DateTime()
}