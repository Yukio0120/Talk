package com.example.talk.ui.screens.other

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.talk.R
import com.example.talk.ui.screens.base.BaseFragment
import com.example.talk.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_doc.*


class DocFragment : BaseFragment(R.layout.fragment_doc) {
    private lateinit var webView: WebView

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Документация"
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
        webView.loadUrl("file:///android_asset/doc.html")
    }

}