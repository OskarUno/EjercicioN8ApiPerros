package com.awakelab.oskar.ejercicion8apiperros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*
[X] Permiso de internet
[X] Dependencias: Coil, Room, Retrofit, navigation, viewModel
[] Repositorio
    [X] Remoto:
        [X] Dataclass
        [X] API (interfaz)
        [X] Retrofit
    [] Local:
        [] Database
        [] Entity
        [] DAO
[] 2 pantallas: Listado y detalle
[] ViewBinding
[] navigation
[] Listado: RecyclerView + ViewHolder + Adapter
[] Detalle: RecyclerView + ViewHolder + Adapter

 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}