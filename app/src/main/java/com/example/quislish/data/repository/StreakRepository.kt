package com.example.quislish.data.repository

import android.content.Context

class StreakRepository(context: Context) {

    private val prefs = context.getSharedPreferences("streak_prefs", Context.MODE_PRIVATE)

    fun getStreak(): Int = prefs.getInt("streak_count", 0)
    fun getLastQuizDate(): Long = prefs.getLong("last_quiz_date", 0L)

    fun updateStreak() {
        val today = System.currentTimeMillis()
        val oneDay = 24 * 60 * 60 * 1000L

        val lastDate = getLastQuizDate()

        val editor = prefs.edit()

        if (lastDate == 0L) {
            // First time
            editor.putInt("streak_count", 1)
        } else {
            val diff = today - lastDate

            when {
                diff < oneDay -> {
                    // Same day → tetep streak
                }
                diff < oneDay * 2 -> {
                    // Dua hari beruntun
                    editor.putInt("streak_count", getStreak() + 1)
                }
                else -> {
                    // Tidak mengerjakan kemarin → reset
                    editor.putInt("streak_count", 1)
                }
            }
        }

        editor.putLong("last_quiz_date", today)
        editor.apply()
    }
}
