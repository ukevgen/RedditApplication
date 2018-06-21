package com.example.reddit.android.ui.main

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.reddit.R
import com.example.reddit.android.DateTimeUtils
import com.example.reddit.domain.model.Post
import kotlinx.android.synthetic.main.item_post.view.*


class PostAdapter(val itemClickListener: (post: Post) -> Unit)
    : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private val postList = mutableListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_post, parent, false))
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    fun dispatchData(newData: List<Post>) {
        val diffResult = DiffUtil.calculateDiff(
                PostsDiffUtilCallback(postList, newData)
        )
        postList.clear()
        postList.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val glideRequestOptions = RequestOptions()
                .centerCrop()
                .error(R.drawable.ic_not_found)
                .diskCacheStrategy(DiskCacheStrategy.ALL)

        fun bind(position: Int) {
            val post = postList[position]
            val passedTime = DateTimeUtils.formatDuration(post.createdTime.millis)

            itemView.setOnClickListener { itemClickListener.invoke(post) }

            itemView.apply {
                tvTitle.text = post.title
                tvPostDetails.text = resources.getString(
                        R.string.post_details_template,
                        passedTime,
                        post.author,
                        post.subreddit)
                tvRattingDetails.text = resources.getString(
                        R.string.post_rating_details,
                        post.score,
                        post.commentsCount ?: 0L,
                        post.likesCount ?: 0L
                )
            }

            Glide.with(itemView.context)
                    .load(post.thumbnail)
                    .apply(glideRequestOptions)
                    .into(itemView.ivPostThumbnail)
        }

    }
}