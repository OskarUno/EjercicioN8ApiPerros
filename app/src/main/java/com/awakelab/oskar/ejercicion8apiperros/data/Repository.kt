package com.awakelab.oskar.ejercicion8apiperros.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.awakelab.oskar.ejercicion8apiperros.data.local.DetalleEntity
import com.awakelab.oskar.ejercicion8apiperros.data.local.RazaDao
import com.awakelab.oskar.ejercicion8apiperros.data.local.RazaEntity
import com.awakelab.oskar.ejercicion8apiperros.data.remote.RazaApi

class Repository(
    private val razaApi: RazaApi,
    private val razaDao: RazaDao,
) {
    fun obtenerRazaEntity(): LiveData<List<RazaEntity>> = razaDao.getAllRazas()
    fun obtenerDetalleRepo(id: String): LiveData<List<DetalleEntity>> = razaDao.getDetalleDao(id)
    suspend fun obtenerRazas() {
        val res = razaApi.getData()             //Datos desde la API

        if (res.isSuccessful) {                   //Consulta si llegan datos
            val message = res.body()!!.message  //Se extrae solo el mensaje
            val keys = message.keys
            keys.forEach {
                val razaEntity = it.toRazaEntiy()
                //val razaEntity = RazaEntity(raza)
                razaDao.insertRaza(razaEntity)
            }
        } else {
            Log.e("Repositorio", res.errorBody().toString())
        }
    }

    suspend fun obtenerDetalleRaza(id: String) {        //id es la raza
        val res = razaApi.getDetalleRaza(id)            //Datos desde la API
        if (res.isSuccessful) {                         //Consulta si llegan datos
            res.body()!!.message.forEach {
                //val razaDetalleEntity = DetalleEntity(id, it)
                val razaDetalleEntity = it.toEntity(id)
                razaDao.insertDetalle(razaDetalleEntity)
            }

        } else {
            Log.e("Repositorio", res.errorBody().toString())
        }
    }

}