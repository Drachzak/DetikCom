package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.detikcom.R
import com.dzak.detikcom.adapter.AdapterNewsUK
import com.dzak.detikcom.adapter.AdapterNewsUS
import com.dzak.detikcom.databinding.ActivityNewsUkBinding
import com.dzak.detikcom.databinding.ActivityNewsUsBinding
import com.dzak.detikcom.model.ResponseBerita
import com.dzak.detikcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsUkActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewsUkBinding
    private var newsadapteruk = AdapterNewsUK()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsUkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            recyclerUk.adapter = newsadapteruk
            recyclerUk.layoutManager = LinearLayoutManager(baseContext)
            recyclerUk.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceUk().headLineUk()
        call.enqueue(object : Callback<ResponseBerita> {
            override fun onResponse(
                call: Call<ResponseBerita>,
                response: Response<ResponseBerita>
            ) {
                val listartikelitemus = response.body()?.articles
                listartikelitemus.let {
                    it?.let { it1 -> newsadapteruk.adddatanewsuk(it1) }
                }
            }


            override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}