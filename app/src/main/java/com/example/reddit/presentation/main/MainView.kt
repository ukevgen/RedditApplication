package com.example.reddit.presentation.main

import com.example.reddit.domain.model.Post
import com.example.reddit.presentation.PresenterView

interface MainView : PresenterView {
    fun renderMessage(message: String)
    fun renderPosts(posts: MutableList<Post>)
    fun renderProgress(visibility: Boolean)
}