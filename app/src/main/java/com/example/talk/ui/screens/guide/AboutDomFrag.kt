package com.example.talk.ui.screens.guide

import android.text.method.LinkMovementMethod
import com.example.talk.R
import com.example.talk.ui.screens.base.BFrag
import kotlinx.android.synthetic.main.fragment_about_dom.*


class AboutDomFrag : BFrag(R.layout.fragment_about_dom) {

    override fun onResume() {
        super.onResume()
        initLink()
    }

    private fun initLink() {
        val mTextView = hyperlink
        val mVk = vk_link
        mTextView.movementMethod = LinkMovementMethod.getInstance()
        mVk.movementMethod = LinkMovementMethod.getInstance()
    }

}