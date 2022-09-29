package com.lifs.infogempa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lifs.infogempa.databinding.ItemRecycleGempaBiasaBinding
import com.lifs.infogempa.model.GempaItem
import com.lifs.infogempa.model.Infogempa

class AdapterGempaBiasa : RecyclerView.Adapter<AdapterGempaBiasa.ViewHolder>() {
    class ViewHolder(var binding: ItemRecycleGempaBiasaBinding) : RecyclerView.ViewHolder(binding.root)
    private val listbiasa : ArrayList<GempaItem> = arrayListOf()
    fun databiasa(ambildata : List<GempaItem>) {
        listbiasa.clear()
        listbiasa.addAll(ambildata)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecycleGempaBiasaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listbiasa[position]
        holder.binding.textView12.text = data.wilayah
        holder.binding.textView14.text = data.potensi
        holder.binding.textView16.text = data.tanggal
        holder.binding.textView18.text = data.jam
        holder.binding.textView20.text = data.magnitude
    }

    override fun getItemCount()= listbiasa.size
}