package com.awakelab.oskar.ejercicion8apiperros.data.remote

import retrofit2.Response
import retrofit2.http.GET
//https://dog.ceo/api/breeds/list/all
interface RazaApi {
    @GET("breeds/list/all")
    suspend fun getData(): Response<RazaDataClass>
}