package com.example.quislish.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.quislish.R
import com.example.quislish.main.BottomNav

class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navHost = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHost.navController

        BottomNav(
            activity = this,
            current = "home"
        ) { target ->
            when (target) {
                "home" -> navController.navigate(R.id.homeFragment)
                "leaderboards" -> navController.navigate(R.id.leaderboardFragment)
                "lesson" -> navController.navigate(R.id.lessonFragment)
                "profile" -> navController.navigate(R.id.profileFragment)
            }
        }.setup()
    }
}