package com.example.quislish.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quislish.lesson.LessonItem
import com.example.quislish.R
import com.example.quislish.databinding.FragmentLessonBinding
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager



class LessonFragment : Fragment() {

    private lateinit var binding: FragmentLessonBinding  // ViewBinding untuk layout fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout menggunakan ViewBinding
        binding = FragmentLessonBinding.inflate(inflater, container, false)
        return binding.root // Kembalikan root view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Membuat list data lesson yang akan ditampilkan ke RecyclerView
        val lessonList = listOf(
            LessonItem(
                "Grammar",
                "lorem ipsum dolor sit amet...",
                "ISI KONTEN GRAMMAR",
                resources.getColor(R.color.purple_200)
            ),
            LessonItem(
                "Lorem Ipsum",
                "lorem ipsum dolor sit amet...",
                "ISI KONTEN LOREM IPSUM",
                resources.getColor(R.color.gray)
            )
        )

        // Inisialisasi adapter dan listener item click
        val adapter = LessonAdapter(lessonList) { item ->
            val bundle = Bundle().apply {
                // Mengirim data ke Fragment Detail
                putString("title", item.title)
                putString("content", item.content)
            }

            // Navigasi ke LessonDetailFragment menggunakan Navigation Component
            findNavController().navigate(
                R.id.actionLessonsToLessonDetail,
                bundle
            )
        }

        // Set RecyclerView
        binding.rvLesson.layoutManager = LinearLayoutManager(requireContext())
        binding.rvLesson.adapter = adapter
    }
}
