package com.example.navegacionfragmentosapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Encontrar el BottomNavigationView
        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_view)

        // 2. Encontrar el NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // 3. Obtener el NavController
        val navController = navHostFragment.navController

        // 4. Conectar el BottomNavigationView con el NavController
        navView.setupWithNavController(navController)
    }
}