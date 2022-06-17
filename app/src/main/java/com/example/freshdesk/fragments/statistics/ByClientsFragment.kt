package com.example.freshdesk.fragments.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freshdesk.R
import com.example.freshdesk.databinding.FragmentByClientsBinding

class ByClientsFragment : Fragment() {
    lateinit var databinding:FragmentByClientsBinding
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
    }
}