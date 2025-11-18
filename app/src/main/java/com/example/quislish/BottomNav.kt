package com.example.quislish

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.widget.ImageView
import android.widget.LinearLayout

class BottomNav(
    private val activity: Activity,
    private val current: String
) {

    fun setup() {

        val navHome = activity.findViewById<LinearLayout>(R.id.navHome)
        val navLeaderboards = activity.findViewById<LinearLayout>(R.id.navLeaderboards)
        val navLesson = activity.findViewById<LinearLayout>(R.id.navLesson)
        val navProfile = activity.findViewById<LinearLayout>(R.id.navProfile)

        val iconHome = activity.findViewById<ImageView>(R.id.iconHome)
        val iconLeaderboards = activity.findViewById<ImageView>(R.id.iconLeaderboards)
        val iconLesson = activity.findViewById<ImageView>(R.id.iconLesson)
        val iconProfile = activity.findViewById<ImageView>(R.id.iconProfile)

        val activeBg = R.drawable.bg_navbar_active
        // Menandai menu aktif
        when (current) {
            "home" -> {
                iconHome.setColorFilter(Color.parseColor("#D3D3D3"))
                iconHome.setBackgroundResource(activeBg)
            }
            "leaderboards" -> {
                iconLeaderboards.setColorFilter(Color.parseColor("#D3D3D3"))
                iconLeaderboards.setBackgroundResource(activeBg)
            }
            "lesson" -> {
                iconLesson.setColorFilter(Color.parseColor("#D3D3D3"))
                iconLesson.setBackgroundResource(activeBg)
            }
            "profile" -> {
                iconProfile.setColorFilter(Color.parseColor("#D3D3D3"))
                iconProfile.setBackgroundResource(activeBg)
            }
//            "home" -> iconLeaderboards.setColorFilter(0xFFFFA726.toInt())
//            "leaderboards" -> iconLeaderboards.setColorFilter(0xFFFFA726.toInt())
//            "lesson" -> iconLesson.setColorFilter(0xFFFFA726.toInt())
//            "profile" -> iconProfile.setColorFilter(0xFFFFA726.toInt())
        }

        navHome.setOnClickListener {
            if (current != "home") {
                activity.startActivity(Intent(activity, HomeActivity::class.java))
                activity.overridePendingTransition(0, 0) // Matikan animasi
                activity.finish() // Opsional: Tutup halaman lama biar tidak menumpuk
            }
        }

        navLeaderboards.setOnClickListener {
            if (current != "leaderboards") {
                activity.startActivity(Intent(activity, LeaderboardsActivity::class.java))
                activity.overridePendingTransition(0, 0) // Matikan animasi
                activity.finish()
            }
        }

        navLesson.setOnClickListener {
            if (current != "lesson") {
                activity.startActivity(Intent(activity, LessonActivity::class.java))
                activity.overridePendingTransition(0, 0) // Matikan animasi
                activity.finish()
            }
        }

        navProfile.setOnClickListener {
            if (current != "profile") {
                activity.startActivity(Intent(activity, ProfileActivity::class.java))
                activity.overridePendingTransition(0, 0) // Matikan animasi
                activity.finish()
            }
        }
    }
}
