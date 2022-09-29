package com.lifs.infogempa.service

import com.lifs.infogempa.model.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitBuild {
    private val client: OkHttpClient = OkHttpClient.Builder().build()

    //mengconfig baseurl
    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://data.bmkg.go.id/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getservicegempaterkini() = retrofit.create(GempaTerkini::class.java)
    fun getservicegempabiasa() = retrofit.create(GempaBiasa::class.java)
    fun getservicegempapotensi() = retrofit.create(GempaPotensi::class.java)
}

interface GempaTerkini {
    @GET("DataMKG/TEWS/autogempa.json")
    fun headlinegempaterkini() : Call<ResponseGempaTerkini>
}
interface GempaBiasa {
    @GET("DataMKG/TEWS/gempaterkini.json")
        fun headlinegempabiasa() : Call<ResponseGempaBiasa>
}
interface GempaPotensi {
    @GET("DataMKG/TEWS/gempadirasakan.json")
    fun headlinegempapotensi() : Call<ResponseGempaPotensi>
}
