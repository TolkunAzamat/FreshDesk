package com.example.freshdesk.fragments.statistics

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freshdesk.R
import com.example.freshdesk.databinding.ByKyrgyzstanMorningFragmentBinding
import com.example.freshdesk.databinding.ByModularyFragmentBinding
import com.example.freshdesk.databinding.FragmentByClientsBinding

class ByModularyFragment : Fragment() {
 lateinit var databinding:ByModularyFragmentBinding
    companion object {
        fun newInstance() = ByModularyFragment()
    }

    private lateinit var viewModel: ByModularyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       databinding=
           ByModularyFragmentBinding.inflate(inflater, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}