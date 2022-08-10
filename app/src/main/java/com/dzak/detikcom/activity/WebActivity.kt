package com.dzak.detikcom.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.dzak.detikcom.R
import com.dzak.detikcom.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWebBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            webview.webViewClient = WebViewClient()

            webview.apply {
                loadUrl("https://kawalcorona.com/")
                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true
            }
        }

    }
}