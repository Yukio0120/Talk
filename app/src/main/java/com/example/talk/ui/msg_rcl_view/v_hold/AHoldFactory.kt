package com.example.talk.ui.msg_rcl_view.v_hold

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talk.R
import com.example.talk.ui.msg_rcl_view.views.MessageView

class AHoldFactory {
    companion object {
        fun getHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return when (viewType) {
                MessageView.MESSAGE_IMAGE -> {
                    val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.msg_i_image, parent, false)
                    HImgMsg(view)
                }
                MessageView.MESSAGE_VOICE -> {
                    val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.msg_i_voice, parent, false)
                    HVMsg(view)
                }
                MessageView.MESSAGE_FILE -> {
                    val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.msg_i_file, parent, false)
                    HFileMsg(view)
                }

                else ->{
                    val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.msg_i_text, parent, false)
                    HTMsg(view)
                }
            }
        }
    }
}