package com.example.sinifishi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.sinifishi.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavView: BottomNavigationView = binding.bottomNavigationView

        // Set up with navController (optional, sets title etc.)
        bottomNavView.setupWithNavController(navController)

        // Manual listener so we override default behavior
        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mainMenuFragment -> {
                    navController.navigate(R.id.mainMenuFragment)
                    true
                }
                R.id.playlistFragment -> {
                    navController.navigate(R.id.playlistFragment)
                    true
                }
                else -> false
            }
        }

        // Listen for destination changes to update bottom nav selection
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.mainMenuFragment -> {
                    bottomNavView.menu.findItem(R.id.mainMenuFragment).isChecked = true
                }
                R.id.playlistFragment -> {
                    bottomNavView.menu.findItem(R.id.playlistFragment).isChecked = true
                }
                else -> {
                    // Uncheck all when not on a main tab
                    bottomNavView.menu.setGroupCheckable(0, true, false)
                    for (i in 0 until bottomNavView.menu.size()) {
                        bottomNavView.menu.getItem(i).isChecked = false
                    }
                    bottomNavView.menu.setGroupCheckable(0, true, true)
                }
            }
        }
    }
}