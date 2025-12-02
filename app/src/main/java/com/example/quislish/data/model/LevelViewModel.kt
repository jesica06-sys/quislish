package com.example.quislish.data.model
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quislish.R


class LevelViewModel : ViewModel() {

    private val _levels = MutableLiveData(
        listOf(
            Level(1, "Very Easy", 6, 10, R.color.purple_200, R.color.purple_400),
            Level(2, "Easy", 6, 10, R.color.blue_200, R.color.blue_400),
            Level(3, "Medium", 6, 10, R.color.orange_200, R.color.orange_400),
            Level(4, "Hard", 6, 10, R.color.red_200, R.color.red_400)
        )
    )
    val levels: LiveData<List<Level>> = _levels

    fun updateProgress(levelId: Int, newProgress: Int) {
        val updated = _levels.value?.map { level ->
            if (level.id == levelId) level.copy(progress = newProgress)
            else level
        }
        _levels.value = updated
    }


}
