package com.example.quislish.navigasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quislish.Level
import com.example.quislish.QuizLevelAdapter
import com.example.quislish.R


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: QuizLevelAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerLevels)

        val levelList = listOf(
            Level(1, "Very Easy", 6, 10, R.color.purple_200),
            Level(2, "Easy", 6, 10, R.color.blue_200),
            Level(3, "Medium", 6, 10, R.color.orange_200),
            Level(4, "Hard", 6, 10, R.color.red_200)
        )

        adapter = QuizLevelAdapter(levelList) { level ->
            // klik item → kembalikan ke activity untuk navigasi
            // kamu sudah punya navigasinya
            Toast.makeText(requireContext(), "Level ${level.id} diklik", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}
