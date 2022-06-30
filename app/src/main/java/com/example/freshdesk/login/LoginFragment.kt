package com.example.freshdesk.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.freshdesk.R
import com.example.freshdesk.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
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
        binding.toolbar.title.text = "Авторизация"
        binding.btn.setOnClickListener {
            login()
        }
    }
    private fun login() {
        viewModel.login(binding.edLogin.text.toString(), binding.edPassword.text.toString()) {
            findNavController().navigate(R.id.action_loginFragment_to_secondSplashFragment)
        }
    }
}