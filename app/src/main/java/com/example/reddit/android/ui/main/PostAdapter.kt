package com.example.reddit.android.ui.main

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reddit.R
import com.example.reddit.android.DateTimeUtils
import com.example.reddit.domain.model.Post
import kotlinx.android.synthetic.main.item_post.view.*


class PostAdapter(val itemClickListener: (post: Post) -> Unit)
    : RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    var postList = mutableListOf<Post>()
        set(value) {
            field.clear()
            when (postList.isEmpty()) {
                true -> {
                    field.addAll(value)
                    notifyDataSetChanged()
                }
                else -> {
                    field.addAll(value)
                    dispatchData(value)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_post, parent, false))
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    private fun dispatchData(newData: List<Post>) {
        val diffResult = DiffUtil.calculateDiff(
                PostsDiffUtilCallback(postList, newData)
        )
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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
        }

    }
}