package com.awakelab.oskar.ejercicion8apiperros.data.remote
//Data Class tiene implementado Getter y Setter, toString, equuals(), hasCode()
data class RazaDataClass(
    val message: Map<String, List<String>>,
    val status: String,
)
