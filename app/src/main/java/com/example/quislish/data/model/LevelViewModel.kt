package com.example.quislish.data.model

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.quislish.R

class LevelViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences("level_progress", Context.MODE_PRIVATE)

    private val _levels = MutableLiveData<List<Level>>()
    val levels: LiveData<List<Level>> = _levels

    init {
        // Muat level + progress yang sudah tersimpan
        _levels.value = listOf(
            Level(1, "Very Easy", loadProgress(1), 10, R.color.purple_200, R.color.purple_400),
            Level(2, "Easy", loadProgress(2), 10, R.color.blue_200, R.color.blue_400),
            Level(3, "Medium", loadProgress(3), 10, R.color.orange_200, R.color.orange_400),
            Level(4, "Hard", loadProgress(4), 10, R.color.red_200, R.color.red_400),
        )
    }

    private fun loadProgress(levelId: Int): Int {
        return prefs.getInt("progress_$levelId", 0)   // default 0
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun updateProgress(levelId: Int, newProgress: Int) {


        prefs.edit().putInt("progress_$levelId", newProgress).apply()

        // Update LiveData
        val updatedLevels = _levels.value?.map { level ->
            if (level.id == levelId) level.copy(progress = newProgress)
            else level
        }
        _levels.value = updatedLevels
    }
}
