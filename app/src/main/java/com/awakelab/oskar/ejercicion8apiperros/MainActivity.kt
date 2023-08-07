package com.awakelab.oskar.ejercicion8apiperros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*
[X] Permiso de internet
[X] Dependencias: Coil, Room, Retrofit, navigation, viewModel
[] 2 pantallas: Listado y detalle
[] ViewBinding
[] navigation
[] Listado: RecyclerView + ViewHolder + Adapter
[] Detalle: RecyclerView + ViewHolder + Adapter
[] Repositorio
[] Remoto:
    [] Dataclass
    [] API (interfaz)
    [] Retrofit
[] Local:
    [] Database
    [] Entity
    [] DAO
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}