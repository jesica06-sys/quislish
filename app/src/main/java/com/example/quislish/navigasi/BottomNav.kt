package com.example.quislish.navigasi

import android.app.Activity
import android.graphics.Color
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.quislish.R

class BottomNav(
    private val activity: Activity,
    private var current: String,                    // ← sekarang mutable (var)
    private val onNavigate: (String) -> Unit
) {

    private lateinit var navHome: LinearLayout
    private lateinit var navLeaderboards: LinearLayout
    private lateinit var navLesson: LinearLayout
    private lateinit var navProfile: LinearLayout

    private lateinit var iconHome: ImageView
    private lateinit var iconLeaderboards: ImageView
    private lateinit var iconLesson: ImageView
    private lateinit var iconProfile: ImageView

    fun setup() {

        navHome = activity.findViewById(R.id.navHome)
        navLeaderboards = activity.findViewById(R.id.navLeaderboards)
        navLesson = activity.findViewById(R.id.navLesson)
        navProfile = activity.findViewById(R.id.navProfile)

        iconHome = activity.findViewById(R.id.iconHome)
        iconLeaderboards = activity.findViewById(R.id.iconLeaderboards)
        iconLesson = activity.findViewById(R.id.iconLesson)
        iconProfile = activity.findViewById(R.id.iconProfile)

        // tampilkan highlight awal
        highlight(current)

        // klik menu
        navHome.setOnClickListener { select("home") }
        navLeaderboards.setOnClickListener { select("leaderboards") }
        navLesson.setOnClickListener { select("lesson") }
        navProfile.setOnClickListener { select("profile") }
    }

    private fun select(target: String) {
        if (current == target) return  // sudah aktif → abaikan

        current = target               // update current
        highlight(target)              // update warna icon
        onNavigate(target)             // panggil fragment
    }

    private fun highlight(target: String) {
        // reset semua icon
        val inactiveColor = Color.WHITE
        val activeColor = Color.parseColor("#D3D3D3")

        iconHome.setColorFilter(inactiveColor)
        iconLeaderboards.setColorFilter(inactiveColor)
        iconLesson.setColorFilter(inactiveColor)
        iconProfile.setColorFilter(inactiveColor)

        iconHome.background = null
        iconLeaderboards.background = null
        iconLesson.background = null
        iconProfile.background = null

        val activeBg = R.drawable.bg_navbar_active

        // aktifkan icon sesuai target
        when (target) {
            "home" -> {
                iconHome.setColorFilter(activeColor)
                iconHome.setBackgroundResource(activeBg)
            }
            "leaderboards" -> {
                iconLeaderboards.setColorFilter(activeColor)
                iconLeaderboards.setBackgroundResource(activeBg)
            }
            "lesson" -> {
                iconLesson.setColorFilter(activeColor)
                iconLesson.setBackgroundResource(activeBg)
            }
            "profile" -> {
                iconProfile.setColorFilter(activeColor)
                iconProfile.setBackgroundResource(activeBg)
            }
        }
    }
}
