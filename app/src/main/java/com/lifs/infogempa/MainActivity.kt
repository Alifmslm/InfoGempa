package com.lifs.infogempa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lifs.infogempa.databinding.ActivityMainBinding
import com.lifs.infogempa.model.ResponseGempaTerkini
import com.lifs.infogempa.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())

        binding.cardView2.setOnClickListener {
            startActivity(Intent(this,GempaBiasaActivity::class.java))
        }

        binding.cardview3.setOnClickListener {
            startActivity(Intent(this,GempaPotensiActivity::class.java))
        }


        val call = RetrofitBuild.getservicegempaterkini().headlinegempaterkini()
        with(call) {
            enqueue(object : Callback<ResponseGempaTerkini>{
                override fun onResponse(
                    call: Call<ResponseGempaTerkini>,
                    response: Response<ResponseGempaTerkini>
                ) {
                    val data = response.body()?.infogempa?.gempa
                    data.let {
                        binding.txtTanggalMain.text = data?.tanggal
                        binding.txtJamMain.text = data?.jam
                        binding.txtMagnitundoMain.text = data?.magnitude
                        binding.txtWilayahMain.text = data?.wilayah
                        binding.txtPotensiMain.text = data?.potensi
                    }
                }

                override fun onFailure(call: Call<ResponseGempaTerkini>, t: Throwable) {
                }
            })
        }
    }
}