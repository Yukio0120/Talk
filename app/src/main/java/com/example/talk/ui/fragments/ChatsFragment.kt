package com.example.talk.ui.fragments

import androidx.fragment.app.Fragment
import com.example.talk.R
import com.example.talk.utilits.APP_ACTIVITY


class ChatsFragment : Fragment(R.layout.fragment_chats) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Чаты"
    }

}