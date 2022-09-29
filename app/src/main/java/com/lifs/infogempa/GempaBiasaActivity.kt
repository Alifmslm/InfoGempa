package com.lifs.infogempa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lifs.infogempa.adapter.AdapterGempaBiasa
import com.lifs.infogempa.databinding.ActivityGempaBiasaBinding
import com.lifs.infogempa.model.GempaItem
import com.lifs.infogempa.model.Infogempa
import com.lifs.infogempa.model.ResponseGempaBiasa
import com.lifs.infogempa.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class GempaBiasaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGempaBiasaBinding
    private val adapter = AdapterGempaBiasa()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGempaBiasaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())

        binding.recycleBiasa.adapter = adapter
        binding.recycleBiasa.layoutManager = LinearLayoutManager(baseContext)
        binding.recycleBiasa.setHasFixedSize(true)

        val call = RetrofitBuild.getservicegempabiasa().headlinegempabiasa()
        with(call){
            enqueue(object : Callback<ResponseGempaBiasa>{
                override fun onResponse(
                    call: Call<ResponseGempaBiasa>,
                    response: Response<ResponseGempaBiasa>
                ) {
                    Timber.d(response.body()?.infogempa.toString())
                    val listprovin = response.body()?.infogempa?.gempa
                    listprovin.let {
                        it?.let { adapter.databiasa(it as List<GempaItem>)}
                    }
                }
                override fun onFailure(call: Call<ResponseGempaBiasa>, t: Throwable) {

                }
            })
        }
    }
}