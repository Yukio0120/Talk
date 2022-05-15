package com.example.talk.ui.msg_recycle_view.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.talk.database.CURRENT_UID
import com.example.talk.ui.msg_recycle_view.views.MessageView
import com.example.talk.utilits.asTime
import com.example.talk.utilits.downloadAndSetImage
import kotlinx.android.synthetic.main.message_item_image.view.*

class HolderImageMessage(view: View): RecyclerView.ViewHolder(view) {
    private val blocReceivedImageMessage:ConstraintLayout = view.bloc_received_image_message
    private val blocUserImageMessage:ConstraintLayout = view.bloc_user_image_message
    private val chatUserImage:ImageView = view.chat_user_image
    private val chatReceivedImage:ImageView = view.chat_received_image
    private val chatUserImageMessageTime:TextView = view.chat_user_image_message_time
    private val chatReceivedImageMessageTime:TextView = view.chat_received_image_message_time




     fun drawMessageImage(holder: HolderImageMessage , view: MessageView) {

        if (view.from == CURRENT_UID) {
            holder.blocReceivedImageMessage.visibility = View.GONE
            holder.blocUserImageMessage.visibility = View.VISIBLE
            holder.chatUserImage.downloadAndSetImage(view.fileUrl)
            holder.chatUserImageMessageTime.text = view.timeStamp.asTime()
        } else {
            holder.blocReceivedImageMessage.visibility = View.VISIBLE
            holder.blocUserImageMessage.visibility = View.GONE
            holder.chatReceivedImage.downloadAndSetImage(view.fileUrl)
            holder.chatReceivedImageMessageTime.text = view.timeStamp.asTime()
        }
    }
}