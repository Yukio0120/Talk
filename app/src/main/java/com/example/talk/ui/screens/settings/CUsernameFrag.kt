package com.example.talk.ui.screens.settings

import com.example.talk.R
import com.example.talk.db.*
import com.example.talk.ui.screens.base.BCFrag
import com.example.talk.utilits.*
import kotlinx.android.synthetic.main.fragment_c_username.*
import java.util.*


class CUsernameFrag : BCFrag(R.layout.fragment_c_username) {

    lateinit var mNewUsername: String
    override fun onResume() {
        super.onResume()
        settings_input_username.setText(USER.username)
    }



    override  fun change() {
        mNewUsername = settings_input_username.text.toString().toLowerCase(Locale.getDefault())
        if (mNewUsername.isEmpty()) {
            showToast(getString(R.string.Empty))

        } else {
            REF_DATABASE_ROOT.child(NODE_USERNAMES)
                .addListenerForSingleValueEvent(AppValueEventListener {
                    if (it.hasChild(mNewUsername)) {
                        showToast(getString(R.string.nickname_exists))
                    } else {
                        changeUsername()
                    }
                })
        }
    }

    private fun changeUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUsername).setValue(CURRENT_UID)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    updateCurrentUsername(mNewUsername)
                }
            }
    }

}