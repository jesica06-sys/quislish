package com.example.quislish.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.quislish.R

class LessonDetail : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_lesson_detail, container, false)
        val title = view.findViewById<TextView>(R.id.lessonDetail)
        title.text = "Lesson Detail"
        return view
    }
}