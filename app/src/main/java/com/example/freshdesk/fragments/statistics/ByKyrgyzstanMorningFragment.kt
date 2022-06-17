package com.example.freshdesk.fragments.statistics

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freshdesk.R
import com.example.freshdesk.databinding.FragmentByClientsBinding

class ByKyrgyzstanMorningFragment : Fragment() {
lateinit var databinding:FragmentByClientsBinding
    companion object {
        fun newInstance() = ByKyrgyzstanMorningFragment()
    }

    private lateinit var viewModel: ByKyrgyzstanMorningViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding= FragmentByClientsBinding.inflate(inflater,container,false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text="На 09:00, Кыргызстан"
    }

}