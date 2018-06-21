package com.example.reddit.data.remote.model

import com.example.reddit.EmptyConstants
import com.google.gson.annotations.SerializedName

class PostItemJson {

    @field:SerializedName("data")
    val postJson: PostJson = PostJson()

    @field:SerializedName("kind")
    val kind: String = EmptyConstants.EMPTY_STRING
}