package com.example.freshdesk.fragments.request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.freshdesk.R
import com.example.freshdesk.adapters.ClientsAdapter
import com.example.freshdesk.adapters.ReportModularAdapter
import com.example.freshdesk.databinding.FragmentByClientsBinding

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
        setadapter()
    }
    fun setadapter(){
        viewModel.list.observe(viewLifecycleOwner){
            databinding.recyclerClients.adapter = ClientsAdapter(it)

        }
    }
}