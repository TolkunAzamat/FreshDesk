package com.example.freshdesk.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.freshdesk.databinding.FragmentProfileBinding
import com.example.freshdesk.sharedPreferences.SharedPreferences
import com.example.freshdesk.utils.alertDialog

class ProfileFragment : Fragment() {
    private lateinit var databinding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        databinding = FragmentProfileBinding.inflate(inflater)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text = "Профиль"
        val sharedPreferences = SharedPreferences(requireContext())
        databinding.user.text = sharedPreferences.username
        databinding.toolbar.exit.setOnClickListener {
            alertDialog(requireContext())
        }
        databinding.cardExit.setOnClickListener {
            alertDialog(requireContext())
        }
    }
}