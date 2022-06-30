package com.example.freshdesk.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.freshdesk.MainActivity
import com.example.freshdesk.R
import com.example.freshdesk.databinding.FragmentFirstSplashBinding
import com.example.freshdesk.utils.sharedPreferences.SharedPreferences

class FirstSplashFragment : Fragment() {
    private lateinit var databinding: FragmentFirstSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding = FragmentFirstSplashBinding.inflate(layoutInflater, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sharedPreferences = SharedPreferences(requireContext())
        if (sharedPreferences.token != null) {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(requireActivity(),
                    MainActivity::class.java))
            }, 1500)
        } else {
            Handler(Looper.getMainLooper()).postDelayed({ findNavController().navigate(R.id.action_firstSplashFragment_to_loginFragment) },
                1500)
        }
    }
}