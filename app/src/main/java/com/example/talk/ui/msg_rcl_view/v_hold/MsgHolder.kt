package com.example.talk.ui.msg_rcl_view.v_hold

import com.example.talk.ui.msg_rcl_view.views.MessageView

interface MsgHolder {
    fun drawMessage(view: MessageView)
    fun onAttach(view: MessageView)
    fun onDetach()
}