package com.example.freshdesk.fragments.request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freshdesk.adapters.MonthStatisticsAdapter
import com.example.freshdesk.adapters.ReportModularAdapter
import com.example.freshdesk.databinding.ByModularyFragmentBinding
import com.example.freshdesk.databinding.FragmentStatisticsBinding
import com.example.freshdesk.fragments.statistics.StatisticsViewModel

class ByModularyFragment : Fragment() {
 lateinit var databinding:ByModularyFragmentBinding
    private val viewModel by lazy { ByModularyViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       databinding=ByModularyFragmentBinding.inflate(inflater, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text="Помодульно"
        setadapter()
        }
    fun setadapter(){
        viewModel.list.observe(viewLifecycleOwner){
            databinding.recyclerModulary.adapter = ReportModularAdapter(it)

        }
    }

}