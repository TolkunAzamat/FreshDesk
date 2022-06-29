package com.example.freshdesk.fragments.request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.freshdesk.R
import com.example.freshdesk.adapters.ClientsAdapter
import com.example.freshdesk.databinding.FragmentByClientsBinding
import com.example.freshdesk.utils.alertDialog
import com.example.freshdesk.utils.isNetworkConnected

class ByClientsFragment : Fragment() {
    lateinit var databinding:FragmentByClientsBinding
    private val viewModel by lazy { ByClientsViewModel() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
    databinding= FragmentByClientsBinding.inflate(inflater,container,false)
    return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text="По клиентам"
        databinding.toolbar.imgBack.setOnClickListener {
        findNavController().navigate(R.id.requestFragment)
        }
        databinding.toolbar.exit.setOnClickListener {
            alertDialog(requireContext())
        }
        checkInternet()
    }
    private fun setAdapter(){
        viewModel.list.observe(viewLifecycleOwner){
            databinding.recyclerClients.adapter = ClientsAdapter(it)

        }
    }
    private fun checkInternet() {
        if (isNetworkConnected(requireContext())) {
            viewModel.clientsReports()
            setAdapter()
        } else Toast.makeText(requireContext(),
            "Отсутсвует подключение к интернету",
            Toast.LENGTH_SHORT).show()
    }

}