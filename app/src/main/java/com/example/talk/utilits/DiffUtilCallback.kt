package com.example.talk.utilits

import com.example.talk.models.CommonModel
import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback (
    private val oldList: List<CommonModel>,
    private val newList: List<CommonModel>
    ) :DiffUtil.Callback(){
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].timeStamp == newList[newItemPosition].timeStamp
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
    }

