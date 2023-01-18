package com.example.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
class WebViewHelpActivity : AppCompatActivity() {
private  lateinit var webview : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_help)
        webview= findViewById(R.id.help)
        webview.webViewClient = WebViewClient()
        webview.loadUrl("https://help.netflix.com/en/")
    }
}
