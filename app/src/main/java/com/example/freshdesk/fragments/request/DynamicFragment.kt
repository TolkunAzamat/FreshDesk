package com.example.freshdesk.fragments.request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.freshdesk.R
import com.example.freshdesk.adapters.DynamicAdapter
import com.example.freshdesk.databinding.DynamicFragmentBinding
import com.example.freshdesk.utils.alertDialog
import com.example.freshdesk.utils.isNetworkConnected

class DynamicFragment : Fragment() {
    lateinit var databinding: DynamicFragmentBinding
    private val viewModel by lazy { DynamicViewModel() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding= DynamicFragmentBinding.inflate(inflater,container,false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text="На 09:00, в динамике"
        databinding.toolbar.imgBack.setOnClickListener {
            findNavController().navigate(R.id.requestFragment)
        }
       checkInternet()
        databinding.toolbar.exit.setOnClickListener {
            alertDialog(requireContext())
        }
    }
   private fun setAdapter() {
        viewModel.list.observe(viewLifecycleOwner) {
        databinding.recyclerDynamic.adapter=DynamicAdapter(it)
        }
    }
    private fun checkInternet() {
        if (isNetworkConnected(requireContext())) {
            viewModel.reportInDynamic()
            setAdapter()
        } else Toast.makeText(requireContext(),
            "Отсутсвует подключение к интернету",
            Toast.LENGTH_SHORT).show()
    }
   }