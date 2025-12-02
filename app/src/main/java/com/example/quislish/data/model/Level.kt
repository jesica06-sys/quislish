package com.example.quislish.data.model

import androidx.annotation.ColorRes

data class Level(
    val id: Int,
    val title: String,
    val progress: Int,
    val total: Int,
    @ColorRes val backgroundColor: Int,
    @ColorRes val color: Int
)