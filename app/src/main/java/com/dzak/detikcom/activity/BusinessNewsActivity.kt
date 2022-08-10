package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.detikcom.R
import com.dzak.detikcom.adapter.AdapterBusiness
import com.dzak.detikcom.databinding.ActivityBusinessNewsBinding
import com.dzak.detikcom.model.ResponseBerita
import com.dzak.detikcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BusinessNewsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBusinessNewsBinding
    private val adapterBusiness = AdapterBusiness()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusinessNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            recyclerBusiness.adapter = adapterBusiness
            recyclerBusiness.layoutManager = LinearLayoutManager(baseContext)
            recyclerBusiness.setHasFixedSize(true)
        }
        val callBusiness = RetrofitBuild.getServiceBusiness().headLineBusiness()
        callBusiness.enqueue(object : Callback<ResponseBerita>{
            override fun onResponse(
                call: Call<ResponseBerita>,
                response: Response<ResponseBerita>
            ) {
                val list = response.body()?.articles
                list.let {
                    it?.let { it1 -> adapterBusiness.adddatanews(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    }
