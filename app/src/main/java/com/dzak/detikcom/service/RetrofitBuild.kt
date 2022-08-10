package com.dzak.detikcom.service

import com.dzak.detikcom.activity.ProvinsiCovidActivity
import com.dzak.detikcom.model.ResponseBerita
import com.dzak.detikcom.model.ResponseCovid
import com.dzak.detikcom.model.ResponseProvinsiCovid
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers

object RetrofitBuild {

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    //mengkonfigurasi URL dasar atau berUrl
    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val retrofitcovid : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.kawalcorona.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val retrofitprovinsi : Retrofit = Retrofit.Builder()
        .baseUrl("https://indonesia-covid-19.mathdro.id/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getServiceIndo() = retrofit.create(NewsTopIndo::class.java)
    fun getServiceUs() = retrofit.create(NewsTopUs::class.java)
    fun getServiceUk() = retrofit.create(NewsTopUk::class.java)
    fun getSembuhCovid() = retrofitcovid.create(SembuhCovid::class.java)
    fun getPositiveCovid() = retrofitcovid.create(PositiveCovid::class.java)
    fun getMeninggalCovid() = retrofitcovid.create(MeninggalCovid::class.java)
    fun getProvinsiCovid() = retrofitprovinsi.create(ProvinsiCovid::class.java)
    fun getServiceBusiness() = retrofit.create(BusinessNews::class.java)
    fun getServiceEntertainment() = retrofit.create(EntertaimentNews::class.java)


}

interface NewsTopIndo {
    @Headers("Authorization: 1753dfffbd0b4d3ebe6ea9dc2615a467")
    @GET("v2/top-headlines?country=id")

    fun headlineIndo() : Call<ResponseBerita>

}
interface NewsTopUs {
    @Headers("Authorization: 1753dfffbd0b4d3ebe6ea9dc2615a467")
    @GET("v2/top-headlines?country=us")

    fun headLineUS() : Call<ResponseBerita>

}
interface NewsTopUk {
    @Headers("Authorization: 1753dfffbd0b4d3ebe6ea9dc2615a467")
    @GET("v2/top-headlines?country=gb")

    fun headLineUk(): Call<ResponseBerita>
}
interface BusinessNews {
    @Headers("Authorization: 1753dfffbd0b4d3ebe6ea9dc2615a467")
    @GET("v2/top-headlines?country=us&category=business")

    fun headLineBusiness(): Call<ResponseBerita>
}
interface EntertaimentNews {
    @Headers("Aurhorization: 173dfffbd0b4d3ebe6ea9dc2615a476")
    @GET("v2/top-headlines?country=us&category=entertainment")

    fun headLineEntertainment(): Call<ResponseBerita>
}
interface SembuhCovid {
    @GET("sembuh/")

    fun RecoveryCovid(): Call<ResponseCovid>
}
interface PositiveCovid {
    @GET("positif/")

    fun PositifCovid(): Call<ResponseCovid>
}
interface MeninggalCovid {
    @GET("meninggal/")

    fun DeadCovid(): Call<ResponseCovid>
}
interface ProvinsiCovid {
    @GET("api/provinsi")

    fun RegionCovid(): Call<ResponseProvinsiCovid>
}
