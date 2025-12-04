package com.example.quislish.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.quislish.R

class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Title (boleh tetap)
        val title = view.findViewById<TextView>(R.id.tvAppName)
        title.text = "Profile Fragment"

        // 1. Ambil username dari SharedPreferences
        val sharedPref = requireActivity().getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "User")

        // 2. Tampilkan ke TextView profil
        val tvUsername = view.findViewById<TextView>(R.id.tvUsername)
        tvUsername.text = username

        return view
    }
}