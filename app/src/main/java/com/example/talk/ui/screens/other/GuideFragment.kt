package com.example.talk.ui.screens.other

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.talk.R
import com.example.talk.ui.screens.base.BaseFragment
import com.example.talk.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_guide.*


class GuideFragment : BaseFragment(R.layout.fragment_guide) {

    private lateinit var webView: WebView

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = getString(R.string.navbar_guide)
        initGuide()
    }

    @SuppressLint("SetJavaScriptEnabled")
     fun initGuide() {
        webView = web_view
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true

        webView.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("file:///android_asset/index.html")
    }

}
