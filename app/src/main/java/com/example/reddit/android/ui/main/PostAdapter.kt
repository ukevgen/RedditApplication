package com.example.reddit.android.ui.main

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reddit.R
import com.example.reddit.android.DateTimeUtils
import com.example.reddit.domain.model.PostDetails
import kotlinx.android.synthetic.main.item_post.view.*


class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    var postDetailsList: List<PostDetails> = listOf()
        set(value) {
            dispatchData(value)
        }

    private fun dispatchData(newData: List<PostDetails>) {
        val diffResult = DiffUtil.calculateDiff(
                PostsDiffUtilCallback(postDetailsList, newData)
        )
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_post, parent, false))
    }

    override fun getItemCount() = postDetailsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            val post = postDetailsList[position]
            val passedTime = DateTimeUtils.formatDuration(post.createdTime.millis)

            itemView.apply {
                tvTitle.text = post.title
                tvPostDetails.text = resources.getString(
                        R.string.post_details_template,
                        passedTime,
                        post.author,
                        post.subreddit)
                tvRattingDetails.text = resources.getString(
                        R.string.post_rating_details,
                        post.commentsCount ?: 0L,
                        post.likesCount ?: 0L
                )

            }
        }

    }
}