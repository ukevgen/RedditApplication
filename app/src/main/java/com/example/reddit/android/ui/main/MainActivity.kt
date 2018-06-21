package com.example.reddit.android.ui.main

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.reddit.R
import com.example.reddit.android.ui.BaseActivity
import com.example.reddit.domain.model.Post
import com.example.reddit.presentation.main.MainPresenter
import com.example.reddit.presentation.main.MainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {


    @Inject lateinit var presenter: MainPresenter
    private lateinit var adaper: PostAdapter

    override fun getActivityPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adaper = PostAdapter({ post -> presenter.onItemClicked(post) })
        val recyclerLayoutManager = LinearLayoutManager(this)

        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(ctx, DividerItemDecoration.VERTICAL))
            addItemDecoration(DividerItemDecoration(ctx, DividerItemDecoration.HORIZONTAL))
            layoutManager = recyclerLayoutManager
            adapter = this@MainActivity.adaper
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    fetchNewData(dy, recyclerLayoutManager)
                }
            })
        }

        presenter.takeView(this)
    }


    override fun renderMessage(message: String) {
        toast(message)
    }

    override fun renderPosts(posts: MutableList<Post>) {
        adaper.dispatchData(posts)
        loading = false
    }

    override fun renderProgress(visibility: Boolean) {
        progressBar.visibility = if (visibility) View.VISIBLE else View.GONE
    }

    private var loading = false

    private fun fetchNewData(dy: Int, layoutManager: LinearLayoutManager) {
        if (dy > 0 && !loading && isLastVisibleItem(layoutManager)) {
            presenter.getPosts()
            loading = true
        }
    }

    private fun isLastVisibleItem(layoutManager: LinearLayoutManager) =
            (layoutManager.childCount + layoutManager.findFirstVisibleItemPosition()) >= layoutManager.itemCount
}
