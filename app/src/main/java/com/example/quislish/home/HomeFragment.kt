package com.example.quislish.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quislish.R
import com.example.quislish.home.QuizLevelAdapter
import com.example.quislish.data.model.LevelViewModel
import com.example.quislish.data.repository.StreakRepository
import android.widget.TextView

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: QuizLevelAdapter

    // SharedViewModel → dipakai HomeFragment & QuizFragment

    val levelViewModel: LevelViewModel by activityViewModels {
        ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val streakRepo = StreakRepository(requireContext())
        val streak = streakRepo.getStreak()

        val txtStreak = view.findViewById<TextView>(R.id.txtStrikeDays)
        txtStreak.text = "You have strike $streak days"

        recyclerView = view.findViewById(R.id.recyclerLevels)

        adapter = QuizLevelAdapter(emptyList()) { level ->
            val bundle = Bundle().apply {
                putInt("levelId", level.id)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_quizFragment,
                bundle
            )
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        levelViewModel.levels.observe(viewLifecycleOwner) { list ->
            adapter.updateData(list)
        }
    }
}
