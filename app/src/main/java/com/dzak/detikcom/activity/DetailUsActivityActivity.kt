package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.dzak.detikcom.R
import com.dzak.detikcom.databinding.ActivityDetailUsActivityBinding

class DetailUsActivityActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailUsActivityBinding

    companion object{
        const val TITTLE_US = "p"
        const val PUBLISHET_US = "d"
        const val IMG_US = "a"
        const val AUTHOR_US = "s"
        const val DESK_US = "k"
        const val CONTENT_US = "b"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTitleUsDetail.text = intent.getStringExtra(TITTLE_US)
        binding.txtPublishatUsDetail.text = intent.getStringExtra(PUBLISHET_US)
        binding.imgUsDetail.load(intent.getStringExtra(IMG_US))
        binding.txtAuthorUsDetail.text = intent.getStringExtra(AUTHOR_US)
        binding.txtDeskUsDetail.text = intent.getStringExtra(DESK_US)
        binding.txtContentUsDetail.text = intent.getStringExtra(CONTENT_US)
    }
}