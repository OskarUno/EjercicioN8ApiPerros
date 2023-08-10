package com.awakelab.oskar.ejercicion8apiperros.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//https://dog.ceo/api/breeds/list/all
interface RazaApi {
    @GET("breeds/list/all")
    suspend fun getData(): Response<RazaDataClass>

    @GET("breed/{id}/images")
    suspend fun getDetalleRaza(@Path("id") id: String): Response<DetalleDataClass>
}