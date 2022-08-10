package com.dzak.detikcom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzak.detikcom.activity.*
import com.dzak.detikcom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKntldetik.setOnClickListener {
            startActivity(Intent(this,NewsIndoActivity::class.java))


        }
        binding.btnNewsUs.setOnClickListener {
            startActivity(Intent(this,NewsUsActivity::class.java))
        }
        binding.btnNewsUK.setOnClickListener {
            startActivity(Intent(this,NewsUkActivity::class.java))
        }
        binding.btnSembuhCovid.setOnClickListener {
            startActivity(Intent(this,SembuhActivity::class.java))
        }
        binding.btnPositiveCovid.setOnClickListener {
            startActivity(Intent(this,PositiveActivity::class.java))
        }
        binding.txtLinkcovid.setOnClickListener {
            startActivity(Intent(this,WebActivity::class.java))
        }
        binding.btnMeninggalCovid.setOnClickListener {
            startActivity(Intent(this,MeninggalActivity::class.java))
        }
        binding.btnProvinsiCovid.setOnClickListener {
            startActivity(Intent(this,ProvinsiCovidActivity::class.java))
        }
        binding.btnBusiness.setOnClickListener {
            startActivity(Intent(this,BusinessNewsActivity::class.java))
        }
        binding.btnEntertainment.setOnClickListener {
            startActivity(Intent(this,EntertaimentNewsActivity::class.java))
        }
    }
}