package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.detikcom.R
import com.dzak.detikcom.adapter.AdapterEntertaiment
import com.dzak.detikcom.databinding.ActivityEntertaimentNewsBinding
import com.dzak.detikcom.model.ResponseBerita
import com.dzak.detikcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EntertaimentNewsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEntertaimentNewsBinding
    private var adapterEntertaiment = AdapterEntertaiment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityEntertaimentNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            recyclerEntertainment.adapter = adapterEntertaiment
            recyclerEntertainment.layoutManager = LinearLayoutManager(baseContext)
            recyclerEntertainment.setHasFixedSize(true)

        }
        val entertainment = RetrofitBuild.getServiceEntertainment().headLineEntertainment()
        entertainment.enqueue(object : Callback<ResponseBerita>{
            override fun onResponse(
                call: Call<ResponseBerita>,
                response: Response<ResponseBerita>
            ) {
                val list = response.body()?.articles
                list.let {
                    it?.let { it1 -> adapterEntertaiment.adddatanews(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}