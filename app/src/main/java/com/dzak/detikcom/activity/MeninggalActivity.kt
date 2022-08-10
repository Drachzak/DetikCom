package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzak.detikcom.R
import com.dzak.detikcom.databinding.ActivityMeninggalBinding
import com.dzak.detikcom.model.ResponseCovid
import com.dzak.detikcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeninggalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMeninggalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeninggalBinding.inflate(layoutInflater)

        val callMeninggal = RetrofitBuild.getMeninggalCovid().DeadCovid()
        callMeninggal.enqueue(object : Callback<ResponseCovid>{
            override fun onResponse(call: Call<ResponseCovid>, response: Response<ResponseCovid>) {
                val list = response.body()
                list.let {
                    binding.txtJudulMeninggal.text = list?.name
                    binding.txtTotalMeninggal.text = list?.value
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}