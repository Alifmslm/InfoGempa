package com.lifs.infogempa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lifs.infogempa.adapter.AdapterGempaBiasa
import com.lifs.infogempa.adapter.AdapterGempaPotensi
import com.lifs.infogempa.databinding.ActivityGempaBiasaBinding
import com.lifs.infogempa.databinding.ActivityGempaPotensiBinding
import com.lifs.infogempa.model.GempaItem
import com.lifs.infogempa.model.GempaItem2
import com.lifs.infogempa.model.Infogempa3
import com.lifs.infogempa.model.ResponseGempaPotensi
import com.lifs.infogempa.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class GempaPotensiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGempaPotensiBinding
    private val adapter = AdapterGempaPotensi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGempaPotensiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclePotensi.adapter = adapter
        binding.recyclePotensi.layoutManager = LinearLayoutManager(baseContext)
        binding.recyclePotensi.setHasFixedSize(true)

        val call = RetrofitBuild.getservicegempapotensi().headlinegempapotensi()
        with(call){
            enqueue(object : Callback<ResponseGempaPotensi>{
                override fun onResponse(
                    call: Call<ResponseGempaPotensi>,
                    response: Response<ResponseGempaPotensi>
                ) {
                    val listpotensi = response.body()?.infogempa?.gempa
                    listpotensi.let {
                        it?.let { adapter.datapotensi(it as List<GempaItem2>)}
                    }
                }

                override fun onFailure(call: Call<ResponseGempaPotensi>, t: Throwable) {

                }
            })
    }
}
}