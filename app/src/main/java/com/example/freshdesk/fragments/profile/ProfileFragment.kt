package com.example.freshdesk.fragments.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.freshdesk.databinding.FragmentProfileBinding
import com.example.freshdesk.login.LoginActivity
import com.example.freshdesk.sharedPreferences.SharedPreferences
import com.example.freshdesk.utils.alertDialog
import com.example.freshdesk.utils.isNetworkConnected

class ProfileFragment : Fragment() {
    private lateinit var databinding:FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
      databinding= FragmentProfileBinding.inflate(inflater)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text="Профиль"
        val shared= SharedPreferences(requireContext())
        databinding.user.text=shared.username
        databinding.toolbar.exit.setOnClickListener {
        alertDialog(requireContext())
        }
        databinding.cardExit.setOnClickListener {
            alertDialog(requireContext())
        }
    }
}