package com.example.freshdesk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.freshdesk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var databinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(databinding.root)
        //setBottomNav()

    }
    private fun setBottomNav(){
        val navController = findNavController(R.id.home_container)
        databinding.reportBtn.setOnClickListener {
            navController.navigate(R.id.action_reportsFragment_to_statisticsFragment)
        }
        databinding.requestBtn.setOnClickListener {  }
    }
}