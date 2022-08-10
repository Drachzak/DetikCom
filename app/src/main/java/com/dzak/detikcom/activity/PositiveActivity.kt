package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzak.detikcom.R
import com.dzak.detikcom.databinding.ActivityPositiveBinding
import com.dzak.detikcom.model.ResponseCovid
import com.dzak.detikcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PositiveActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPositiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPositiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val callPositive = RetrofitBuild.getPositiveCovid().PositifCovid()
        callPositive.enqueue(object : Callback<ResponseCovid>{
            override fun onResponse(call: Call<ResponseCovid>, response: Response<ResponseCovid>) {
                val list = response.body()
                list.let {
                    binding.txtJudulPositive.text = list?.name
                    binding.txtTotalPositive.text = list?.value
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {

            }

        })
    }
}