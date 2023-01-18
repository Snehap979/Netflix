package com.example.netflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.RelativeLayout

class ManageProfileActivity : AppCompatActivity() {
    private lateinit var accountPage: RelativeLayout
    private  lateinit var helpPage: RelativeLayout
    private  lateinit var webview : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_profile)
        accountPage = findViewById(R.id.accountItem)
        accountPage.setOnClickListener{
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }
        helpPage=findViewById(R.id.helpWeb)
        helpPage.setOnClickListener{
            val intent = Intent(this, WebViewHelpActivity::class.java)
            startActivity(intent)
        }
//        webview= findViewById(R.id.help)
//        webview.webViewClient = WebViewClient()
//        webview.loadUrl("https://help.netflix.com/en/")
    }
}