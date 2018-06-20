package com.example.reddit.data.remote.model

import com.google.gson.annotations.SerializedName

class TopPostsResponse {

    @field:SerializedName("data")
    val data: PostDataJson = PostDataJson()
}