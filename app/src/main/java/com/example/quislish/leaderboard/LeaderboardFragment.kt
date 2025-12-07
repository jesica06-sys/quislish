package com.example.quislish.leaderboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quislish.R
import com.example.quislish.data.model.UserRank
import com.example.quislish.databinding.FragmentLeaderboardBinding
// jangan import ItemUserRankBinding jika tidak perlu; tapi boleh tetap ada

class LeaderboardFragment : Fragment() {

    private var _binding: FragmentLeaderboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUserRank()
        setupWorldRank()
    }

    private fun setupUserRank() {
        // Dummy user login
        val userRank = UserRank(
            rank = 10,
            name = "Fakhruddin",
            points = 100,
            colorRes = R.color.red_400
        )
        val user = binding.layoutUserRank

        val sharedPref = requireActivity().getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "User")
        user.txtRank.text = userRank.rank.toString()
        user.txtName.text = username
        user.txtDescription.text = "lorem ipsum dolor sit amet blukutuk blukutuk"
        user.txtPoints.text = "✦${userRank.points}"

        // ganti sesuai id di item_user_rank.xml, misal cardView atau containerLayout
        // jika id di xml adalah "card_view" maka:
        user.cardView.setBackgroundResource(userRank.colorRes)
        // jika id berbeda, gunakan nama binding property yang sesuai (cek generated binding)
    }

    private fun setupWorldRank() {
        val dummyWorldRank = listOf(
            UserRank(1, "Alice", 100, R.color.purple_200),
            UserRank(2, "Budi", 100, R.color.blue_200),
            UserRank(3, "Cindy", 100, R.color.orange_200),
            UserRank(4, "Doni", 100, R.color.red_400),
        )

        binding.recyclerWorldRank.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.recyclerWorldRank.adapter = WorldRankAdapter(dummyWorldRank)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
