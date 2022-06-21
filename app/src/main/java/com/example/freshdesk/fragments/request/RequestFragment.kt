package com.example.freshdesk.fragments.request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.freshdesk.R
import com.example.freshdesk.databinding.FragmentRequestBinding

class RequestFragment : Fragment() {
    private lateinit var databinding:FragmentRequestBinding
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       databinding= FragmentRequestBinding.inflate(layoutInflater,container,false)
       return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    databinding.toolbar.title.text="Заявки"
        databinding.byModule.setOnClickListener {
            findNavController().navigate(R.id.byModularyFragment)
        }
        databinding.byClients.setOnClickListener {
            findNavController().navigate(R.id.byClientsFragment)
        }
        databinding.kg.setOnClickListener {
            findNavController().navigate(R.id.byKyrgyzstanMorningFragment)
        }
        databinding.byDynamic.setOnClickListener {
            findNavController().navigate(R.id.dynamicFragment)
        }
    }
}