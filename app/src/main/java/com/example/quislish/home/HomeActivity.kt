package com.example.quislish.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quislish.R



class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Load fragment default
        replaceFragment(HomeFragment())



        // Setup bottom navbar
        BottomNav(
            activity = this,
            current = "home"
        ) { target ->
            when (target) {
                "home" -> replaceFragment(HomeFragment())
                "leaderboards" -> replaceFragment(LeaderboardFragment())
                "lesson" -> replaceFragment(LessonFragment())
                "profile" -> replaceFragment(ProfileFragment())
            }}.setup()
    }

    fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
