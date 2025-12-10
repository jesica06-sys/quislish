package com.example.quislish.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.quislish.R

class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavContainer: View   // << deklarasi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavContainer = findViewById(R.id.bottomNav)
        val navHost = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.navController

        val fragmentName = intent.getStringExtra("fragment")
        if (fragmentName != null) {
            when (fragmentName) {
                "home" -> {
                    navController.popBackStack(R.id.homeFragment, false)
                    navController.navigate(R.id.homeFragment)
                }
                "leaderboards" -> navController.navigate(R.id.leaderboardFragment)
                "lesson" -> navController.navigate(R.id.lessonFragment)
                "profile" -> navController.navigate(R.id.profileFragment)
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val hideOn = setOf(
                R.id.quizFragment
            )

            if (destination.id in hideOn) {
                bottomNavContainer.visibility = View.GONE
            } else {
                bottomNavContainer.visibility = View.VISIBLE
            }
        }

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
