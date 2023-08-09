package com.awakelab.oskar.ejercicion8apiperros.data

import androidx.lifecycle.LiveData
import com.awakelab.oskar.ejercicion8apiperros.data.local.RazaDao
import com.awakelab.oskar.ejercicion8apiperros.data.local.RazaEntity
import com.awakelab.oskar.ejercicion8apiperros.data.remote.RazaApi

class Repository(
    private val razaApi: RazaApi,
    private val razaDao: RazaDao,
) {
    fun obtenerRazaEntity(): LiveData<List<RazaEntity>> = razaDao.getAllRazas()
    suspend fun obtenerRazas() {
        val res = razaApi.getData()             //Datos desde la API

        if (res.isSuccessful) {                   //Consulta si llegan datos
            val message = res.body()!!.message  //Se extrae solo el mensaje
            val keys = message.keys
            keys.forEach{
                val razaEntity = RazaEntity(it)
                razaDao.insertRaza(razaEntity)
            }
        }
    }

}