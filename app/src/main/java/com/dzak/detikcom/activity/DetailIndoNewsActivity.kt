package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.dzak.detikcom.R
import com.dzak.detikcom.databinding.ActivityDetailIndoNewsBinding
import com.dzak.detikcom.databinding.ActivityNewsIndoBinding

class DetailIndoNewsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailIndoNewsBinding

    companion object {
        const val TITLE_uk  = "T"
        const val PUBLISHAT_uk = "P"
        const val IMG_uk = "I"
        const val AUTHOR_uk = "A"
        const val DESK_uk = "D"
        const val CONTENT_uk = "C"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailIndoNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTitleIndoDetail.text = intent.getStringExtra(TITLE_uk)
        binding.txtPublishatIndoDetail.text = intent.getStringExtra(PUBLISHAT_uk)
        binding.imgIndoDetail.load(intent.getStringExtra(IMG_uk))
        binding.txtAuthorIndoDetail.text = intent.getStringExtra(AUTHOR_uk)
        binding.txtDeskIndoDetail.text = intent.getStringExtra(DESK_uk)
        binding.txtContentIndoDetail.text = intent.getStringExtra(CONTENT_uk)

    }
}



