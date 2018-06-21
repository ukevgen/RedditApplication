package com.example.reddit.presentation.main

import com.example.reddit.domain.model.Post
import com.example.reddit.domain.model.PostData
import com.example.reddit.domain.usecase.GetPostsUseCase
import com.example.reddit.presentation.BasePresenter
import io.reactivex.SingleTransformer
import io.reactivex.observers.DisposableSingleObserver
import java.net.UnknownHostException
import javax.inject.Inject

class MainPresenter @Inject constructor(private val getPostsUseCase: GetPostsUseCase) : BasePresenter<MainView>() {

    private var afterPostKey = ""
    private val postList = mutableListOf<Post>()

    override fun onViewShown() {
        super.onViewShown()
        getPosts()
    }

    fun getPosts() {
        view?.renderProgress(true)
        getPostsUseCase.execute(object : DisposableSingleObserver<PostData>() {
            override fun onSuccess(postData: PostData) {
                afterPostKey = postData.lastPostKey
                postList.addAll(postData.posts)
                view?.renderPosts(postList)
            }

            override fun onError(e: Throwable) {
                when (e) {
                    is UnknownHostException -> view?.renderMessage("Please, check your internet connection")
                    else -> view?.renderMessage(e.localizedMessage)
                }
                e.printStackTrace()
            }
        }, SingleTransformer { upstream ->
            upstream.doFinally {
                view?.renderLoadDataAccessibility(true)
                view?.renderProgress(false)
            }
        }, GetPostsUseCase.Params(afterPostKey))
    }

    fun onItemClicked(post: Post) {
        view?.renderPostDetails(post.articleLink)
    }

}