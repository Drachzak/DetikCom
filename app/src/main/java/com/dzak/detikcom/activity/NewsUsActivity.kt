package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.detikcom.R
import com.dzak.detikcom.adapter.AdapterNewsUS
import com.dzak.detikcom.databinding.ActivityNewsUsBinding
import com.dzak.detikcom.model.ResponseBerita
import com.dzak.detikcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsUsBinding
    private var newsadapterUS = AdapterNewsUS()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recycleNewsUs.adapter = newsadapterUS
            recycleNewsUs.layoutManager = LinearLayoutManager(baseContext)
            recycleNewsUs.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceUs().headLineUS()
        call.enqueue(object : Callback<ResponseBerita> {
            override fun onResponse(
                call: Call<ResponseBerita>,
                response: Response<ResponseBerita>
            ) {
                val listArtikel = response.body()?.articles
                listArtikel.let {
                    it?.let { it1 -> newsadapterUS.addDataNewsUs(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}

