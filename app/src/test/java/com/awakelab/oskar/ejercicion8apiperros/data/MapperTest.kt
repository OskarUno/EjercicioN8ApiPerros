package com.awakelab.oskar.ejercicion8apiperros.data

import org.junit.Assert.assertEquals
import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {
        //Given (Dado este valor)
        val url = "http://example.com"
        val id = "id"

        //fun String.toEntity(id: String): DetalleEntity = DetalleEntity(id, this)
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

        //fun String.toRazaEntiy(): RazaEntity = RazaEntity(this)
        //When (Hago esta acción)
        val res = raza.toRazaEntiy()

        //Then (Espero este resultado)
        assertEquals(raza, res.raza)
    }
}
