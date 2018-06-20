package com.example.reddit.presentation.main

import android.support.v7.util.DiffUtil
import com.example.reddit.domain.model.PostData
import com.example.reddit.domain.model.PostDetails
import com.example.reddit.domain.usecase.GetPostsUseCase
import com.example.reddit.presentation.BasePresenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class MainPresenter @Inject constructor(private val getPostsUseCase: GetPostsUseCase) : BasePresenter<MainView>() {

    private var afterPostKey = ""

    override fun onTakeView(view: MainView) {
        super.onTakeView(view)

        getPosts()
    }

    fun getPosts() {
        getPostsUseCase.execute(object : DisposableSingleObserver<PostData>() {
            override fun onSuccess(postData: PostData) {
                afterPostKey = postData.lastPostKey
                view?.renderPosts(postData.posts)
            }

            override fun onError(e: Throwable) {
                view?.renderMessage(e.localizedMessage)
                e.printStackTrace()
            }

        }, GetPostsUseCase.Params(afterPostKey))
    }

}