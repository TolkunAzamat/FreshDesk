package com.example.freshdesk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import com.example.freshdesk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setBottomNav()

    }
    private fun setBottomNav(){
        val navController = findNavController(R.id.home_container)
        binding.reportBtn.setOnClickListener {
            navController.navigate(R.id.reportsFragment)
        }
        binding.requestBtn.setOnClickListener {
            navController.navigate(R.id.requestFragment)
        }
        binding.statisticsBtn.setOnClickListener {
            navController.navigate(R.id.statisticsFragment)
        }
    }
}