package com.example.freshdesk.fragments.request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.freshdesk.R
import com.example.freshdesk.adapters.MorningKgAdapter
import com.example.freshdesk.databinding.ByKyrgyzstanMorningFragmentBinding
import com.example.freshdesk.utils.alertDialog
import com.example.freshdesk.utils.isNetworkConnected

class ByKyrgyzstanMorningFragment : Fragment() {
    lateinit var databinding: ByKyrgyzstanMorningFragmentBinding
    private val viewModel by lazy { ByKyrgyzstanMorningViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding = ByKyrgyzstanMorningFragmentBinding.inflate(inflater, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text = "На 09:00, Кыргызстан"
        databinding.toolbar.imgBack.setOnClickListener {
            findNavController().navigate(R.id.requestFragment)
        }
        databinding.toolbar.exit.setOnClickListener {
            alertDialog(requireContext())
        }
        checkInternet()
    }
    private fun setAdapter() {
        viewModel.list.observe(viewLifecycleOwner) {
            databinding.recyclerAgents.adapter = MorningKgAdapter(it)

        }
    }
    private fun checkInternet() {
        if (isNetworkConnected(requireContext())) {
            viewModel.agentsReport()
            setAdapter()
        } else Toast.makeText(requireContext(),
            "Отсутсвует подключение к интернету",
            Toast.LENGTH_SHORT).show()
    }
}