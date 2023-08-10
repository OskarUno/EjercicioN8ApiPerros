package com.awakelab.oskar.ejercicion8apiperros.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RazaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(razaEntity: RazaEntity)
    @Query("select * from tabla_raza_detalle where razaDetalle like :id")
    fun getDetalleDao(id: String): LiveData<List<DetalleEntity>>

    @Query("select * from tabla_raza order by raza ASC")
    fun getAllRazas(): LiveData<List<RazaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetalle(detalleEntity: DetalleEntity)
}