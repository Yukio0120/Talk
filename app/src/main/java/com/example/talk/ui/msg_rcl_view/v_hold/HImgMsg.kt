package com.example.talk.ui.msg_rcl_view.v_hold

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.talk.db.CURRENT_UID
import com.example.talk.ui.msg_rcl_view.views.MessageView
import com.example.talk.utilits.asTime
import com.example.talk.utilits.downloadAndSetImage
import kotlinx.android.synthetic.main.msg_i_image.view.*

class HImgMsg(view: View) : RecyclerView.ViewHolder(view), MsgHolder {
    private val blocReceivedImageMessage: ConstraintLayout = view.bloc_received_image_message
    private val blocUserImageMessage: ConstraintLayout = view.bloc_user_image_message
    private val chatUserImage: ImageView = view.chat_user_image
    private val chatReceivedImage: ImageView = view.chat_received_image
    private val chatUserImageMessageTime: TextView = view.chat_user_image_message_time
    private val chatReceivedImageMessageTime: TextView = view.chat_received_image_message_time


    override fun drawMessage(view: MessageView) {
        if (view.from == CURRENT_UID) {
            blocReceivedImageMessage.visibility = View.GONE
            blocUserImageMessage.visibility = View.VISIBLE
            chatUserImage.downloadAndSetImage(view.fileUrl)
            chatUserImageMessageTime.text = view.timeStamp.asTime()
        } else {
            blocReceivedImageMessage.visibility = View.VISIBLE
            blocUserImageMessage.visibility = View.GONE
            chatReceivedImage.downloadAndSetImage(view.fileUrl)
            chatReceivedImageMessageTime.text = view.timeStamp.asTime()
        }
    }

    override fun onAttach(view: MessageView) {
    }

    override fun onDetach() {
    }
}