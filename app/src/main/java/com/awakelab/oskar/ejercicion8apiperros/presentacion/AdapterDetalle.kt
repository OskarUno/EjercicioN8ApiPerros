package com.awakelab.oskar.ejercicion8apiperros.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.ejercicion8apiperros.data.local.DetalleEntity
import com.awakelab.oskar.ejercicion8apiperros.data.local.RazaEntity
import com.awakelab.oskar.ejercicion8apiperros.databinding.ItemDetalleBinding

class AdapterDetalle : RecyclerView.Adapter<AdapterDetalle.DetalleViewHolder>() {
    lateinit var binding: ItemDetalleBinding
    private val listDetalle = mutableListOf<DetalleEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AdapterDetalle.DetalleViewHolder {
        binding = ItemDetalleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetalleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDetalle.size
    }

    override fun onBindViewHolder(holder: AdapterDetalle.DetalleViewHolder, position: Int) {
        val detalleItem = listDetalle[position]
        holder.render(detalleItem)
    }

    fun setData(detalle: List<DetalleEntity>) {
        this.listDetalle.clear()
        this.listDetalle.addAll(detalle)
        notifyDataSetChanged()
    }

    class DetalleViewHolder(val detalles: ItemDetalleBinding) :
        RecyclerView.ViewHolder(detalles.root) {
        fun render(detalleItem: DetalleEntity) {
            detalles.iv.load(detalleItem.url)
        }

    }
}