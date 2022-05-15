package com.example.talk.ui.msg_recycle_view.view_holders

import com.example.talk.ui.msg_recycle_view.views.MessageView

interface MessageHolder {
    fun drawMessage(view: MessageView)
    fun onAttach(view: MessageView)
    fun onDetach()
}