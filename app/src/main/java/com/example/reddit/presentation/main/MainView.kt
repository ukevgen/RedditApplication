package com.example.reddit.presentation.main

import com.example.reddit.domain.model.PostDetails
import com.example.reddit.presentation.PresenterView

interface MainView : PresenterView {
    fun renderMessage(message: String)
    fun renderPosts(posts: List<PostDetails>)
}