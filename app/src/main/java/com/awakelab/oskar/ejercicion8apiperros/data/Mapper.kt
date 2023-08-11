package com.awakelab.oskar.ejercicion8apiperros.data

import com.awakelab.oskar.ejercicion8apiperros.data.local.DetalleEntity
import com.awakelab.oskar.ejercicion8apiperros.data.local.RazaEntity

//Funcion de extensión
fun String.toEntity(id: String): DetalleEntity = DetalleEntity(id, this)

fun String.toRazaEntiy(): RazaEntity = RazaEntity(this)