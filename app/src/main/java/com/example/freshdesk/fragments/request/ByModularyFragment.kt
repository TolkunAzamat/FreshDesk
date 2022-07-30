package com.example.freshdesk.fragments.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.freshdesk.R
import com.example.freshdesk.adapters.ReportModularAdapter
import com.example.freshdesk.databinding.ByModularyFragmentBinding
import com.example.freshdesk.utils.alertDialog
import com.example.freshdesk.utils.isNetworkConnected

class ByModularyFragment : Fragment() {
    lateinit var databinding: ByModularyFragmentBinding
    private val viewModel by lazy { ByModularyViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding = ByModularyFragmentBinding.inflate(inflater, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text = "Помодульно"
        databinding.toolbar.imgBack.setOnClickListener {
            findNavController().navigate(R.id.requestFragment)
        }
        setAdapter()
        databinding.toolbar.exit.setOnClickListener {
            alertDialog(requireContext())
        }
        checkInternet()
    }

    private fun setAdapter() {
        viewModel.list.observe(viewLifecycleOwner) {
            databinding.recyclerModulary.adapter = ReportModularAdapter(it)

        }
    }

    private fun checkInternet() {
        if (isNetworkConnected(requireContext())) {
            viewModel.moduleReports()
            setAdapter()
        } else Toast.makeText(requireContext(),
            "Отсутсвует подключение к интернету",
            Toast.LENGTH_SHORT).show()
    }
}