package com.example.quislish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.content.Intent
import com.example.quislish.HomeActivity
import com.example.quislish.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLeaderboards = findViewById<LinearLayout>(R.id.navLeaderboards)
        val navLesson = findViewById<LinearLayout>(R.id.navLesson)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)

        navHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        navLeaderboards.setOnClickListener {
            startActivity(Intent(this, LeaderboardsActivity::class.java))
        }

        navLesson.setOnClickListener {
            startActivity(Intent(this, LessonActivity::class.java))
        }

        navProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
