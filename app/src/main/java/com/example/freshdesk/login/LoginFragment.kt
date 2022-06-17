package com.example.freshdesk.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.freshdesk.MainActivity
import com.example.freshdesk.R
import com.example.freshdesk.databinding.FragmentLoginBinding
import com.example.freshdesk.sharedPreferences.SharedPreferences

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private val viewModel by lazy { LoginViewModel() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title.text="Авторизация"
        binding.btn.setOnClickListener {
            login()
        }
    }

    private fun login() {
        viewModel.login(binding.edLogin.text.toString(), binding.edPassword.text.toString()) {
            findNavController().navigate(R.id.action_loginFragment_to_secondSplashFragment)
            Toast.makeText(requireContext(), SharedPreferences(requireContext()).token, Toast.LENGTH_SHORT).show()
        }
    }
}