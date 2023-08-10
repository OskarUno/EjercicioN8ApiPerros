package com.awakelab.oskar.ejercicion8apiperros.data.local

import androidx.room.Entity

@Entity(tableName = "tabla_raza_detalle", primaryKeys = ["razaDetalle", "url"])
data class DetalleEntity(
    val razaDetalle: String,
    val url: String,
)
