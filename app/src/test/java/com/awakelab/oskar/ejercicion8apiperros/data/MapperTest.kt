package com.awakelab.oskar.ejercicion8apiperros.data

import com.awakelab.oskar.ejercicion8apiperros.data.local.DetalleEntity
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {
        //Given (Dado este valor)
        val url = "http://example.com"
        val id = "id"

        //When (Hago esta acción)
        val res = url.toEntity(id)

        //Then (Espero este resultado)
        assertEquals(id, res.razaDetalle)
        assertEquals(url, res.url)
    }

    @Test
    fun toRazaEntiy() {
        //Given (Dado este valor)
        val raza = "Esta es una Raza"

        //When (Hago esta acción)
        val res = raza.toRazaEntiy()

        //Then (Espero este resultado)
        assertEquals(raza, res.raza)
    }
}
