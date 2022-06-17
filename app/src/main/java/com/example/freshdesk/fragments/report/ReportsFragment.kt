package com.example.freshdesk.fragments.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freshdesk.R
import com.example.freshdesk.databinding.FragmentRequestBinding


class ReportsFragment : Fragment() {
private lateinit var databinding:FragmentRequestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding= FragmentRequestBinding.inflate(inflater,container,false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text="Отчеты"
    }
}