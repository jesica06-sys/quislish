package com.example.quislish

import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quislish.main.HomeActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = findViewById<EditText>(R.id.username)
        val btnNext = findViewById<Button>(R.id.button2)


        btnNext.setOnClickListener {
            val name = username.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "Username wajib diisi!", Toast.LENGTH_SHORT).show()
            } else {


                val sharedPref = getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("username", name)
                editor.apply()


                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}