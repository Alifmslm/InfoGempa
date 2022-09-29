package com.lifs.infogempa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lifs.infogempa.databinding.ItemRecycleGempaBiasaBinding
import com.lifs.infogempa.model.GempaItem
import com.lifs.infogempa.model.GempaItem2

class AdapterGempaPotensi : RecyclerView.Adapter<AdapterGempaPotensi.ViewHolder>() {
    class ViewHolder (var binding: ItemRecycleGempaBiasaBinding) : RecyclerView.ViewHolder(binding.root)
    private val listpotensi : ArrayList<GempaItem2> = arrayListOf()
    fun datapotensi(ambildata : List<GempaItem2>){
        listpotensi.clear()
        listpotensi.addAll(ambildata)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecycleGempaBiasaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listpotensi[position]
        holder.binding.textView12.text = data.wilayah
        holder.binding.textView14.text = data.dirasakan
        holder.binding.textView16.text = data.tanggal
        holder.binding.textView18.text = data.jam
        holder.binding.textView20.text = data.magnitude
    }

    override fun getItemCount()= listpotensi.size
}