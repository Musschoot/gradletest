package com.hogent.squads.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hogent.squads.R
import com.hogent.squads.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main_activity) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavigation = binding.bottomNavigation

        setupBottomNav()
        println("createdHomeActivity")
    }

    private fun setupBottomNav() {
        bottomNavigation.menu.findItem(R.id.bottom_nav_home).isChecked = true;
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_nav_calendar -> {
                    navController.navigate(MainActivityDirections.calendarFragmentAction())
                    println("nav calendar")
                    true
                }

                R.id.bottom_nav_home -> {
                    navController.navigate(MainActivityDirections.homeFragmentAction())
                    println("nav home")
                    true
                }

                R.id.bottom_nav_stats -> {
                    navController.navigate(MainActivityDirections.statsFragmentAction())
                    println("nav stats")
                    true
                }

                else -> false
            }
        }
    }
}
