package com.example.freshdesk.fragments.request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freshdesk.adapters.ClientsAdapter
import com.example.freshdesk.adapters.MorningKgAdapter
import com.example.freshdesk.databinding.ByKyrgyzstanMorningFragmentBinding
import com.example.freshdesk.databinding.FragmentByClientsBinding

class ByKyrgyzstanMorningFragment : Fragment() {
lateinit var databinding:ByKyrgyzstanMorningFragmentBinding
    private val viewModel by lazy { ByKyrgyzstanMorningViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding= ByKyrgyzstanMorningFragmentBinding.inflate(inflater,container,false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text="На 09:00, Кыргызстан"
        setadapter()
    }
    fun setadapter(){
        viewModel.list.observe(viewLifecycleOwner){
            databinding.recyclerAgents.adapter = MorningKgAdapter(it)

        }
    }
}