package com.example.reddit.android.ui.main

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import com.example.reddit.R
import com.example.reddit.android.ui.BaseActivity
import com.example.reddit.domain.model.PostDetails
import com.example.reddit.presentation.main.MainPresenter
import com.example.reddit.presentation.main.MainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {


    @Inject lateinit var presenter: MainPresenter
    lateinit var adaper: PostAdapter

    override fun getActivityPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adaper = PostAdapter()
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(ctx, DividerItemDecoration.VERTICAL))
            addItemDecoration(DividerItemDecoration(ctx, DividerItemDecoration.HORIZONTAL))
        }
        recyclerView.adapter = adaper

        presenter.takeView(this)
    }

    override fun renderMessage(message: String) {
        toast(message)
    }

    override fun renderPosts(posts: List<PostDetails>) {
        adaper.postDetailsList = posts
    }
}
