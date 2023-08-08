package com.awakelab.oskar.ejercicion8apiperros.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "tabla_raza")
data class RazaEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val raza : String
)
