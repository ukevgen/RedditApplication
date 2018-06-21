package com.example.reddit.android.ui.main

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
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
    private lateinit var adapter: PostAdapter

    override fun getActivityPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = PostAdapter({ post -> presenter.onItemClicked(post) })
        val recyclerLayoutManager = LinearLayoutManager(this)

        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(ctx, DividerItemDecoration.VERTICAL))
            addItemDecoration(DividerItemDecoration(ctx, DividerItemDecoration.HORIZONTAL))
            layoutManager = recyclerLayoutManager
            adapter = this@MainActivity.adapter
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
        adapter.dispatchData(posts)
    }

    override fun renderProgress(visibility: Boolean) {
        progressBar.visibility = if (visibility) View.VISIBLE else View.GONE
    }

    override fun renderPostDetails(articleLink: String?) {
        val customTabsIntent = CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setShowTitle(true)
                .build()
        customTabsIntent.launchUrl(this, Uri.parse(articleLink))

    }

    override fun renderLoadDataAccessibility(access : Boolean) {
        loadingAccess = access
    }

    // Private
    private var loadingAccess = true

    private fun fetchNewData(dy: Int, layoutManager: LinearLayoutManager) {
        if (dy > 0 && loadingAccess && isLastVisibleItem(layoutManager)) {
            presenter.getPosts()
            renderLoadDataAccessibility(false)
        }
    }

    private fun isLastVisibleItem(layoutManager: LinearLayoutManager) =
            (layoutManager.childCount + layoutManager.findFirstVisibleItemPosition()) >= layoutManager.itemCount
}
