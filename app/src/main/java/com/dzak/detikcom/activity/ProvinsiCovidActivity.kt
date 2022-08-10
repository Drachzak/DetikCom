package com.dzak.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.detikcom.R
import com.dzak.detikcom.adapter.AdapterProvinsiCovid
import com.dzak.detikcom.databinding.ActivityProvinsiCovidBinding
import com.dzak.detikcom.model.ResponseProvinsiCovid
import com.dzak.detikcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinsiCovidActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProvinsiCovidBinding
    private val provadapter = AdapterProvinsiCovid()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProvinsiCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            RecyclerProv.adapter = provadapter
            RecyclerProv.layoutManager = LinearLayoutManager(baseContext)
            RecyclerProv.setHasFixedSize(true)

        }

        val provinsicall = RetrofitBuild.getProvinsiCovid().RegionCovid()
        provinsicall.enqueue(object : Callback<ResponseProvinsiCovid>{
            override fun onResponse(
                call: Call<ResponseProvinsiCovid>,
                response: Response<ResponseProvinsiCovid>
            ) {
                val listartikel = response.body()?.data
                listartikel.let {
                    it?.let { it1 -> provadapter.addDataProv(it1) }
                }
                }

            override fun onFailure(call: Call<ResponseProvinsiCovid>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })



        }
    }

