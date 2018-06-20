package com.example.reddit.android.ui.main

import android.support.v7.util.DiffUtil
import com.example.reddit.domain.model.PostDetails

class PostsDiffUtilCallback(val oldList: List<PostDetails>,
                            val newList: List<PostDetails>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            areItemsTheSame(oldItemPosition, newItemPosition)

}
