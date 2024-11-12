package com.example.jokes_application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        if (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) == null) {
            val navHostFragment = NavHostFragment.create(R.navigation.nav_graph)
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, navHostFragment)
                .setPrimaryNavigationFragment(navHostFragment)
                .commitNow()
        }

        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
