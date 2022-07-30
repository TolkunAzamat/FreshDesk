package com.example.freshdesk.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freshdesk.MainActivity
import com.example.freshdesk.R
import com.example.freshdesk.databinding.FragmentSecondSplashBinding

class SecondSplashFragment : Fragment() {
    private lateinit var databinding:FragmentSecondSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding= FragmentSecondSplashBinding.inflate(layoutInflater)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(requireActivity(),
                MainActivity::class.java))
        }, 1500)
        databinding.toolbar1.title.text="Авторизация"
    }
}