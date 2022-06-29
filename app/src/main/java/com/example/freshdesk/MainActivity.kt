package com.example.freshdesk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ReportFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import com.example.freshdesk.databinding.ActivityMainBinding
import com.example.freshdesk.fragments.request.RequestFragment
import com.example.freshdesk.fragments.statistics.StatisticsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var databinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(databinding.root)
        setBottomNav()

    }
    private fun setBottomNav(){
        databinding.reportBtn.isChecked = true

        val navController = findNavController(R.id.container)
        databinding.reportBtn.setOnClickListener {
            navController.popBackStack(R.id.reportsFragment, true)
            navController.navigate(R.id.reportsFragment)
        }
        databinding.requestBtn.setOnClickListener {
            navController.popBackStack(R.id.requestFragment, true)
            navController.navigate(R.id.requestFragment)
        }
        databinding.statisticsBtn.setOnClickListener {
            navController.popBackStack(R.id.statisticsFragment, true)
            navController.navigate(R.id.statisticsFragment)
        }
        databinding.profileBtn.setOnClickListener {
            navController.popBackStack(R.id.profileFragment, true)
            navController.navigate(R.id.profileFragment)
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.reportsFragment -> showBottomNav()
                R.id.statisticsFragment -> showBottomNav()
                R.id.requestFragment -> showBottomNav()
                R.id.profileFragment->showBottomNav()
                else -> hideBottomNav()
            }
            when (destination.id) {
                R.id.reportsFragment -> databinding.reportBtn.isChecked = true
                R.id.statisticsFragment -> databinding.statisticsBtn.isChecked = true
                R.id.requestFragment -> databinding.requestBtn.isChecked = true
                R.id.profileFragment->databinding.profileBtn.isChecked=true
            }
        }
    }

    private fun showBottomNav() {
        databinding.cardView.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        databinding.cardView.visibility = View.GONE
    }
}