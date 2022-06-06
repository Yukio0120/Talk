package com.example.talk.ui.screens.settings

import com.example.talk.R
import com.example.talk.db.USER
import com.example.talk.db.setBioToDb
import com.example.talk.ui.screens.base.BCFrag
import kotlinx.android.synthetic.main.fragment_c_bio.*

class CBioFrag : BCFrag(R.layout.fragment_c_bio) {
    override fun onResume() {
        super.onResume()
        settings_input_bio.setText(USER.bio)
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()
        setBioToDb(newBio)
    }

}