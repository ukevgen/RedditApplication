package com.example.reddit.data.remote.model

import com.example.reddit.EmptyConstants
import com.google.gson.annotations.SerializedName

class PostDataJson {

    @field:SerializedName("after")
    val lastPostKey: String = EmptyConstants.EMPTY_STRING

    @field:SerializedName("children")
    val postItems: List<PostItemJson> = listOf()

    @field:SerializedName("dist")
    val count: Long = EmptyConstants.EMPTY_LONG


}