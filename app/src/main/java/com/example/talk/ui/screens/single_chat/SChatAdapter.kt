package com.example.talk.ui.screens.single_chat

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talk.ui.msg_rcl_view.v_hold.*
import com.example.talk.ui.msg_rcl_view.views.MessageView

class SingleChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mListMessagesCache = mutableListOf<MessageView>()
    private var mListHolders = mutableListOf<MsgHolder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return AHoldFactory.getHolder(parent,viewType)
    }

    override fun getItemViewType(position: Int): Int {
       return mListMessagesCache[position].getTypeView()
    }

    override fun getItemCount(): Int = mListMessagesCache.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MsgHolder).drawMessage(mListMessagesCache[position])

    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        (holder as MsgHolder).onAttach(mListMessagesCache[holder.adapterPosition])
        mListHolders.add((holder as MsgHolder))
        super.onViewAttachedToWindow(holder)
    }


    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        (holder as MsgHolder).onDetach()
        mListHolders.remove((holder as MsgHolder))
        super.onViewDetachedFromWindow(holder)
    }

    fun addItemToBottom(item: MessageView,
                        onSuccess: () -> Unit){
        if (!mListMessagesCache.contains(item)) {
            mListMessagesCache.add(item)
            notifyItemInserted(mListMessagesCache.size)
        }
        onSuccess()
    }

    fun addItemToTop(item: MessageView,
                     onSuccess: () -> Unit){
        if (!mListMessagesCache.contains(item)) {
            mListMessagesCache.add(item)
            mListMessagesCache.sortBy { it.timeStamp.toString() }
            notifyItemInserted(0)
        }
        onSuccess()
    }

    fun onDestroy() {
        mListHolders.forEach {
            it.onDetach()
        }
    }
}

