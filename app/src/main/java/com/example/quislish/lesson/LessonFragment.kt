package com.example.quislish.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quislish.lesson.LessonItem
import com.example.quislish.R
import com.example.quislish.databinding.FragmentLessonBinding

class LessonFragment : Fragment() {

    private lateinit var binding: FragmentLessonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLessonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lessonList = listOf(
            LessonItem(
                "Grammar",
                "lorem ipsum dolor sit amet...",
                resources.getColor(R.color.purple_200)
            ),
            LessonItem(
                "Lorem Ipsum",
                "lorem ipsum dolor sit amet...",
                resources.getColor(R.color.gray)
            )
        )

//        val adapter = LessonAdapter(lessonList) { item ->
//            val action = LessonFragmentDirections
//                .actionLessonFragmentToLessonDetail(
//                    title = item.title,
//                    description = item.description
//                )
//            findNavController().navigate(action)
//        }
//
//        binding.rvLesson.layoutManager = LinearLayoutManager(requireContext())
//        binding.rvLesson.adapter = adapter
    }
}