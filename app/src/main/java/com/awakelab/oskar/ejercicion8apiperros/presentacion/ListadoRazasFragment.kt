package com.awakelab.oskar.ejercicion8apiperros.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.awakelab.oskar.ejercicion8apiperros.databinding.FragmentListadoRazasBinding

class ListadoRazasFragment : Fragment() {
    lateinit var binding: FragmentListadoRazasBinding
    private val razaVM: RazaViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListadoRazasBinding.inflate(layoutInflater, container, false)
        initAdapter()
        razaVM.getAllIRazas()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterRazas()
        binding.rv.adapter = adapter

        razaVM.razaLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}