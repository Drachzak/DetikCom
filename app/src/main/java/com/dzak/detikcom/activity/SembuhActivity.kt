package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzak.detikcom.R
import com.dzak.detikcom.databinding.ActivitySembuhBinding
import com.dzak.detikcom.model.ResponseCovid
import com.dzak.detikcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SembuhActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySembuhBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySembuhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val callSembuh = RetrofitBuild.getSembuhCovid().RecoveryCovid()
        callSembuh.enqueue(object : Callback<ResponseCovid>{
            override fun onResponse(call: Call<ResponseCovid>, response: Response<ResponseCovid>) {
                val list = response.body()
                list.let {
                    binding.txtJudul.text = list?.name
                    binding.txtTotal.text = list?.value
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}