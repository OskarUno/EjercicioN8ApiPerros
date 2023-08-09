package com.awakelab.oskar.ejercicion8apiperros.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awakelab.oskar.ejercicion8apiperros.data.local.RazaEntity
import com.awakelab.oskar.ejercicion8apiperros.databinding.ItemRazasBinding

class AdapterRazas : RecyclerView.Adapter<AdapterRazas.ItemRazasViewHolder>() {
    lateinit var binding: ItemRazasBinding
    private val listItemRazas = mutableListOf<RazaEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AdapterRazas.ItemRazasViewHolder {
        binding = ItemRazasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemRazasViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemRazas.size
    }

    override fun onBindViewHolder(holder: ItemRazasViewHolder, position: Int) {
        val razaItem = listItemRazas[position]
        holder.render(razaItem)
    }

    fun setData(razas: List<RazaEntity>) {
        this.listItemRazas.clear()
        this.listItemRazas.addAll(razas)
        notifyDataSetChanged()
    }

    class ItemRazasViewHolder(val razas: ItemRazasBinding) : RecyclerView.ViewHolder(razas.root) {
        fun render(raza: RazaEntity) {
            razas.tvRaza.text = raza.raza
        }
    }
}