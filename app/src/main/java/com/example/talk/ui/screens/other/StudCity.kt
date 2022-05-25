package com.example.talk.ui.screens.other

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.talk.R
import com.example.talk.ui.screens.base.BFrag
import com.example.talk.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_doc.*


class StudCity : BFrag(R.layout.fragment_stud_city) {
    private lateinit var webView: WebView

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = getString(R.string.stud_site)
        initDoc()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initDoc() {
        webView = web_doc_view
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true

        webView.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("https://hall.donstu.ru/news/")
    }
}