package com.awakelab.oskar.ejercicion8apiperros.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.awakelab.oskar.ejercicion8apiperros.R
import com.awakelab.oskar.ejercicion8apiperros.databinding.FragmentDetalleBinding

private const val ARG_PARAM1 = "raza"

class DetalleFragment : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    private var param1: String? = null

    private val razaVM: RazaViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)
        razaVM.getRazaVM(param1.toString())
       // binding.tvRazaDetalle.text = param1.toString()
        initAdapter()
        razaVM.getRazaVM(param1.toString())
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterDetalle()
        binding.rv.adapter = adapter
        razaVM.detalleLiveData(param1.toString()).observe(viewLifecycleOwner){
            adapter.setData(it)
        }



    }

}