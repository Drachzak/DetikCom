package com.dzak.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dzak.detikcom.R
import com.dzak.detikcom.adapter.AdaoterNewsIndo
import com.dzak.detikcom.databinding.ActivityMainBinding
import com.dzak.detikcom.databinding.ActivityNewsIndoBinding
import com.dzak.detikcom.model.ArticlesItem
import com.dzak.detikcom.model.ResponseBerita
import com.dzak.detikcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsIndoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsIndoBinding
    private val newsadapter = AdaoterNewsIndo()
    private var isloading = false
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsIndoBinding.inflate(layoutInflater)




        with(binding) {
            setContentView(root)
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setLogo(R.drawable.img_1)
                setDisplayUseLogoEnabled(true)
            }
            RecyclerNewsIndo.adapter = newsadapter
            RecyclerNewsIndo.layoutManager = LinearLayoutManager(baseContext)
            RecyclerNewsIndo.setHasFixedSize(true)

            fabNews.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,"Hey,Ada aplikasi bagus nih:")
                intent.type="text/plain"
                startActivity(Intent.createChooser(intent,"Share to:"))
            }
        }
        val call = RetrofitBuild.getServiceIndo().headlineIndo()
        //call enque untuk mengambil data dari internet
        call.enqueue(object : Callback<ResponseBerita> {
            override fun onResponse(
                call: Call<ResponseBerita>,
                response: Response<ResponseBerita>
            ) {
                val listartikelitem = response.body()?.articles
                listartikelitem.let {
                    it?.let { it1 -> newsadapter.adddatanews(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }
}