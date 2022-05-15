package com.example.talk.ui.screens

import androidx.fragment.app.Fragment
import com.example.talk.R
import com.example.talk.utilits.APP_ACTIVITY
import com.example.talk.utilits.hideKeyboard


class MainFragment : Fragment(R.layout.fragment_chats) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Talk"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
    }

}