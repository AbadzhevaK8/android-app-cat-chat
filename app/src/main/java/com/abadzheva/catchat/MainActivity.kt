package com.abadzheva.catchat

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import by.kirich1409.viewbindingdelegate.viewBinding
import com.abadzheva.catchat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind, R.id.drawer_layout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the Toolbar
        setSupportActionBar(binding.toolbar)
        // Get the NavController
        val navHostFragment =
            supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Configure AppBar with DrawerLayout
        val appBarConfiguration =
            AppBarConfiguration
                .Builder(navController.graph)
                .setOpenableLayout(binding.drawerLayout) // Set the DrawerLayout with icon
                .build()

        // Link Toolbar with NavController
//        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        // Here I'll try to add custom icon to the Toolbar
        val toggle =
            ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close,
            )
        binding.drawerLayout.addDrawerListener(toggle)

        // Disable the standard icon and install your own
        toggle.isDrawerIndicatorEnabled = false
        binding.toolbar.setNavigationIcon(R.drawable.baseline_lunch_dining_24)

        // Add a handler to open DrawerLayout
        binding.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(binding.navView)
        }

        toggle.syncState()

        // Set up NavigationView
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController) ||
            super.onOptionsItemSelected(item)
    }
}
