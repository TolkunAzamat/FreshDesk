package com.example.freshdesk.fragments.request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.freshdesk.databinding.FragmentRequestBinding

class RequestFragment : Fragment() {
    private lateinit var databinding:FragmentRequestBinding
    //private var viewModel:ViewModel by lazy { RequestViewModel()}
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       databinding= FragmentRequestBinding.inflate(layoutInflater,container,false)
       return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    databinding.toolbar.title.text="Заяки"
    }
}