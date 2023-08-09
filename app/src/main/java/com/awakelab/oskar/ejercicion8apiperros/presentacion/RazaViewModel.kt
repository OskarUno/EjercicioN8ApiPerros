package com.awakelab.oskar.ejercicion8apiperros.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.awakelab.oskar.ejercicion8apiperros.data.Repository
import com.awakelab.oskar.ejercicion8apiperros.data.local.RazaDataBase
import com.awakelab.oskar.ejercicion8apiperros.data.remote.RazaRetrofit
import kotlinx.coroutines.launch

class RazaViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository
    fun razaLiveData() = repository.obtenerRazaEntity()
    init {
        val api = RazaRetrofit.getRetrofitRaza()
        val dao = RazaDataBase.getDatabase(application).getRazaDao()
        repository = Repository(api, dao)
    }

    fun getAllIRazas() = viewModelScope.launch {
        repository.obtenerRazas()
    }
}
