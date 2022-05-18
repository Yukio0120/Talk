package com.example.talk.ui.msg_rcl_view.v_hold

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.talk.db.CURRENT_UID
import com.example.talk.ui.msg_rcl_view.views.MessageView
import com.example.talk.utilits.asTime
import kotlinx.android.synthetic.main.msg_i_text.view.*

class HTMsg(view: View) : RecyclerView.ViewHolder(view), MsgHolder {
    private val blocUserMessage: ConstraintLayout = view.bloc_user_message
    private val chatUserMessage: TextView = view.chat_user_message
    private val chatUserMessageTime: TextView = view.chat_user_message_time
    private val blocReceivedMessage: ConstraintLayout = view.bloc_other_user_message
    private val chatReceivedMessage: TextView = view.chat_other_user_message
    private val chatReceivedMessageTime: TextView = view.chat_other_user_message_time


    override fun drawMessage(view: MessageView) {
        if (view.from == CURRENT_UID) {
            blocUserMessage.visibility = View.VISIBLE
            blocReceivedMessage.visibility = View.GONE
            chatUserMessage.text = view.text
            chatUserMessageTime.text =
                view.timeStamp.asTime()
        } else {
            blocUserMessage.visibility = View.GONE
            blocReceivedMessage.visibility = View.VISIBLE
            chatReceivedMessage.text = view.text
            chatReceivedMessageTime.text =
                view.timeStamp.asTime()
        }
    }

    override fun onAttach(view: MessageView) {
    }

    override fun onDetach() {
    }
}